package com.book.service.Impl;

import com.book.pojo.Parameter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParameterServiceImplTest {
private ParameterServiceImpl parameterService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring/applicationContext.xml",
                "Spring/applicationContext-mybatis.xml");
        parameterService = (ParameterServiceImpl) context.getBean("parameterServiceImpl");

    }

    @Test
    public void getParameters() {
        Parameter parameter=parameterService.getParameters();
        System.out.println(parameter.getCost());
    }
}