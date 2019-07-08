package com.book.service.Impl;

import com.book.pojo.Bookinfo;
import com.book.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServiceImplTest {

private BookService bookService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring/applicationContext.xml",
                "Spring/applicationContext-mybatis.xml");
        bookService= (BookService) context.getBean("bookServiceImpl");
    }

    @Test
    public void listBook() {
        Map<String,Object> m=new HashMap();

        m.put("bookcase","A");
        List<Bookinfo> list=bookService.getBookQuery(m);
        for (Bookinfo i:list
             ) {
            System.out.println(i.getBookname());
        }

    }
}