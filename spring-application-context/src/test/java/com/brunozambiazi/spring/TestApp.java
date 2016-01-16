package com.brunozambiazi.spring;

import com.brunozambiazi.spring.service.SecondService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

    @SuppressWarnings("resource")
    @BeforeClass
    public static void setUp() {
        new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void getBeanByName() {
        SecondService service = (SecondService) ContextProvider.getBean("secondService");
        Assert.assertTrue(service.isEverythingOk());
    }

    @Test
    public void getBeanByType() {
        SecondService service = ContextProvider.getBean(SecondService.class);
        Assert.assertTrue(service.isEverythingOk());
    }

}
