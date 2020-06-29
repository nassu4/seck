package com.czh.seck.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class SuccessKilledOrderMapperTest {

    private static SqlSessionFactory factory;
    private SqlSession sess = null;
    private ISuccessKilledOrderMapper mapper = null;

    static {
        String path = "config/mybatis-config.xml";
        InputStream in = SuccessKilledOrderMapperTest.class.getClassLoader().getResourceAsStream(path);
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @Before
    public void init() {
        sess = factory.openSession();
        mapper = sess.getMapper(ISuccessKilledOrderMapper.class);
    }

    @After
    public void release() {
        sess.commit();
        sess.close();
    }

    @Test
    public void create_order_test() {
        System.out.println(mapper.createOrder(1L, 13973991919L));
    }

    @Test
    public void query_by_id_with_stock_test() {
        System.out.println(mapper.queryByIdWithStock(1L, 13973991919L));
    }

}
