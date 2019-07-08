package com.book.service.Impl;

import com.book.pojo.Reader;
import com.book.service.ReaderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReaderServiceImplTest {
private ReaderService readerService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring/applicationContext.xml",
                "Spring/applicationContext-mybatis.xml");
        readerService= (ReaderService) context.getBean("readerServiceImpl");
    }

    @Test
    public void getReaderList() {
        Reader list = readerService.getReaderCode("101010");
        System.out.println(list.getId());
        System.out.println(list.getReaderType().getNumber());

    }
}