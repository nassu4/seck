package com.czh.seck.controller;

import com.czh.seck.dto.ExecutionResult;
import com.czh.seck.dto.Exposer;
import com.czh.seck.dto.RequestResult;
import com.czh.seck.dto.StockResult;
import com.czh.seck.entity.Stock;
import com.czh.seck.service.ISeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seckill")
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ISeckillService service;

    @GetMapping("/list")
    public List<StockResult> list() {
        List<StockResult> list = new ArrayList<>();
        for (Stock stock : service.queryAllStock())
            list.add(new StockResult(stock));
        return list;
    }

    @GetMapping("/{item_id}/detail")
    public Stock detail(@PathVariable("item_id") Long itemId) {
        if (itemId == null) return null;
        return service.queryStockById(itemId);
    }

    @GetMapping("/{item_id}/exposer")
    public RequestResult<Exposer> exposer(@PathVariable("item_id") Long itemId) {
        try {
            Exposer exposer = service.exportSeckillUrl(itemId);
            return new RequestResult<>(200, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new RequestResult<>(404, "获取URL失败");
        }
    }

    @PostMapping("/{item_id}/{md5}/execution")
    public RequestResult<ExecutionResult> execute(@PathVariable("item_id") Long itemId,
                                                  @PathVariable("md5") String md5,
                                                  @CookieValue(value = "user_phone_number", required = false) Long phone) {
        try {
            ExecutionResult result = service.executeSeckill(itemId, phone, md5);
            return new RequestResult<>(200, result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new RequestResult<>(404, "秒杀失败");
        }
    }

    @GetMapping("/time/now")
    public LocalDateTime time() {
        return LocalDateTime.now();
    }

}
