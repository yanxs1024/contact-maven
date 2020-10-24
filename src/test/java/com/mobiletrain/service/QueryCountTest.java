package com.mobiletrain.service;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class QueryCountTest {
    @Test
    public void init() {
        ClassPathApplicationContext context = new ClassPathApplicationContext();
    this.service = context.getBean("contactServiceImpl",ContactService.class)''

    }
}
