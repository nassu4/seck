package com.czh.seck.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:config/spring-dao-config.xml",
        "classpath:config/spring-service-config.xml",
        "classpath:/config/spring-mvc-config.xml"
})
public class SeckillControllerTest {

    @Autowired
    private SeckillController controller;

    @Test
    public void list() {
        System.out.println(controller.list());
    }

}
