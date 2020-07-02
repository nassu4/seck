package com.czh.seck.service;

import com.czh.seck.dto.ExecutionResult;
import com.czh.seck.dto.Exposer;
import com.czh.seck.exception.ReWriteException;
import com.czh.seck.exception.RepeatedKillException;
import com.czh.seck.exception.SeckillClosedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao-config.xml", "classpath:config/spring-service-config.xml"})
public class SeckillServiceTest {

    @Autowired
    ISeckillService service;

    @Test
    public void query_stock_by_id_test() {
        System.out.println(service.queryStockById(5));
    }

    @Test
    public void query_all_stock_by_id_test() {
        System.out.println(service.queryAllStock());
    }

    @Test
    public void seckill_logic_test() {
        Exposer exposer = service.exportSeckillUrl(2L);
        if (exposer.isExposed()) {
            try {
                ExecutionResult executionResult = service.executeSeckill(exposer.getItemId(),
                        13983719381L, exposer.getMd5());
                System.out.println(executionResult);
            } catch (ReWriteException | SeckillClosedException | RepeatedKillException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("秒杀未开启：" + exposer);
        }
    }

}
