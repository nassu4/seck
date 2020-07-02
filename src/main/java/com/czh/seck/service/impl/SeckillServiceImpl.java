package com.czh.seck.service.impl;

import com.czh.seck.dto.ExecutionResult;
import com.czh.seck.dto.Exposer;
import com.czh.seck.entity.Stock;
import com.czh.seck.entity.SuccessKilledOrder;
import com.czh.seck.enums.SeckillResultEnum;
import com.czh.seck.exception.ExecutionException;
import com.czh.seck.exception.ReWriteException;
import com.czh.seck.exception.RepeatedKillException;
import com.czh.seck.exception.SeckillClosedException;
import com.czh.seck.mapper.IStockMapper;
import com.czh.seck.mapper.ISuccessKilledOrderMapper;
import com.czh.seck.service.ISeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeckillServiceImpl implements ISeckillService {

    private static final String SALT = "1yuhjnAKJ@JNskjfnksnd0*(&%^B@";

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IStockMapper iStockMapper;
    @Autowired
    private ISuccessKilledOrderMapper iSuccessKilledOrderMapper;

    @Override
    public Stock queryStockById(long itemId) {
        return iStockMapper.queryById(itemId);
    }

    @Override
    public List<Stock> queryAllStock() {
        return iStockMapper.queryAll(0, 4);
    }

    @Override
    public Exposer exportSeckillUrl(long itemId) {
        Stock stock = queryStockById(itemId);
        if (stock == null)
            return new Exposer(false, itemId);
        LocalDateTime startTime = stock.getStartTime();
        LocalDateTime endTime = stock.getEndTime();
        LocalDateTime now = LocalDateTime.now();
        now = now.withMonth(11).withDayOfMonth(11);
        System.out.println(now);
        if (now.isBefore(startTime) || now.isAfter(endTime))
            return new Exposer(false, itemId, now, startTime, endTime);
        return new Exposer(true, getMD5(itemId), itemId);
    }

    private String getMD5(long itemId) {
        return DigestUtils.md5DigestAsHex((itemId + SALT).getBytes());
    }

    @Override
    @Transactional
    public ExecutionResult executeSeckill(long itemId, long userPhone, String md5) throws ExecutionException {
        if (md5 == null || !md5.equals(getMD5(itemId))) throw new ReWriteException("seckill data rewrite");
        try {
            int updateRows = iStockMapper.reduceStock(itemId, LocalDateTime.now().withMonth(11).withDayOfMonth(11));
            if (updateRows <= 0) throw new SeckillClosedException("seckill is closed");
            int insertRows = iSuccessKilledOrderMapper.createOrder(itemId, userPhone);
            if (insertRows <= 0) throw new RepeatedKillException("repeated kill");
            SuccessKilledOrder order = iSuccessKilledOrderMapper.queryByIdWithStock(itemId, userPhone);
            return new ExecutionResult(itemId, SeckillResultEnum.SUCCESS, order);
        } catch (SeckillClosedException | RepeatedKillException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ExecutionException("Execution exception", e);
        }
    }

}
