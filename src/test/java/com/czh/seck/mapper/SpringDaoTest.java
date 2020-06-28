package com.czh.seck.mapper;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.Month;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao-config.xml"})
public class SpringDaoTest {
    @Autowired
    IStockMapper stockMapper;
    @Autowired
    ISuccessKilledOrderMapper successKilledOrderMapper;

    @Test
    public void reduce_stock_test() {
        int res = stockMapper.reduceStock(4L, LocalDateTime.of(2020, Month.NOVEMBER, 11, 1, 2, 3));
        System.out.println("-------------------------------------------------------------------");
        System.out.println(LocalDateTime.now());
        System.out.println(res);
    }

    @Test
    public void query_by_id_test() {
        System.out.println(stockMapper.queryById(3));
    }

    @Test
    public void create_order_test() {
        System.out.println(successKilledOrderMapper.createOrder(4L, 13973991919L));
    }

    @Test
    public void query_by_id_with_stock_test() {
        System.out.println(successKilledOrderMapper.queryByIdWithStock(4L, 13973991919L));
    }
}
