package com.book.service.Impl;

import com.book.pojo.Bookcase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookcaseServiceImplTest {
   BookcaseServiceImpl bookcaseService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring/applicationContext.xml",
                "Spring/applicationContext-mybatis.xml");
            bookcaseService = (BookcaseServiceImpl) context.getBean("bookcaseServiceImpl");
    }

    @Test
    public void getBookcaseList() {
        List<Bookcase> list= bookcaseService.getBookcaseList();
        for (Bookcase book:list
             ) {
            System.out.println(book.getName());
        }
    }
}