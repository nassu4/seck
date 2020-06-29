package com.czh.seck.service;

import com.czh.seck.exception.ExecutionException;
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
    public void queryStockById() {
        System.out.println(service.queryStockById(2));
    }

    @Test
    public void queryAllStockById() {
        System.out.println(service.queryAllStockById());
    }

    @Test
    public void exportSeckillUrl() {
        System.out.println(service.exportSeckillUrl(1));
    }

    @Test
    public void executeSeckill() {
        try {
            System.out.println(service.executeSeckill(1, 123, "asd"));
        } catch (ExecutionException e) {
            System.out.println(e);
        }
    }

}
