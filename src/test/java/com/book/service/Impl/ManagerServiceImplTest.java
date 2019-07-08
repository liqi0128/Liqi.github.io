package com.book.service.Impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagerServiceImplTest {
    ManagerServiceImpl managerService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring/applicationContext.xml",
                "Spring/applicationContext-mybatis.xml");
        managerService = (ManagerServiceImpl) context.getBean("managerServiceImpl");
    }

    @Test
    public void getManagerPurviewList() {

    }
}