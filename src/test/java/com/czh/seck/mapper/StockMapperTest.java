package com.czh.seck.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.Month;

public class StockMapperTest {

    private static SqlSessionFactory factory;
    private SqlSession sess = null;
    private IStockMapper mapper = null;

    static {
        String path = "config/mybatis-config.xml";
        InputStream in = StockMapperTest.class.getClassLoader().getResourceAsStream(path);
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @Before
    public void init() {
        sess = factory.openSession();
        mapper = sess.getMapper(IStockMapper.class);
    }

    @After
    public void release() {
        sess.commit();
        sess.close();
    }

    @Test
    public void reduce_stock_test() {
        int res = mapper.reduceStock(1L, LocalDateTime.of(2020, Month.NOVEMBER, 11, 1, 2, 3));
        System.out.println("-------------------------------------------------------------------");
        System.out.println(LocalDateTime.now());
        System.out.println(res);
    }

    @Test
    public void query_by_id_test() {
        System.out.println(mapper.queryById(2));
    }

    @Test
    public void query_all_test() {
        System.out.println(mapper.queryAll(0, 100));
    }

}
