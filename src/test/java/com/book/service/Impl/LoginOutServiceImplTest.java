package com.book.service.Impl;

import com.book.pojo.Manager;
import com.book.service.LoginOutService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginOutServiceImplTest {
LoginOutService loginOutService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("spring/applicationContext.xml"
                ,"spring/applicationContext-mybatis.xml",
                "MyBatis/mybatis-config.xml"
        );
loginOutService = (LoginOutService) context.getBean("LoginOutServiceImpl");
    }

    @Test
    public void login() {
        Manager manager=new Manager();
        manager.setName("java1234");
        manager.setPwd("1234");
        Manager m = loginOutService.Login(manager);
        System.out.println(m.getName());
    }
}