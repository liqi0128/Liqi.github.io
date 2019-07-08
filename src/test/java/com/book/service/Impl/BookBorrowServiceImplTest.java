package com.book.service.Impl;

import com.book.pojo.Borrow;
import com.book.service.BookBorrowService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookBorrowServiceImplTest {
    private BookBorrowService bookBorrowService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring/applicationContext.xml",
                "Spring/applicationContext-mybatis.xml");
        bookBorrowService= (BookBorrowService) context.getBean("bookBorrowServiceImpl");
    }

    @Test
    public void getListRenew() {
        Map<String,Object> map = new HashMap<>();
        map.put("sdate","2013-05-01");
        map.put("edate","2013-05-04");



        List<Borrow> list = bookBorrowService.getBorrowQuery(map);
        for (Borrow b:list
             ) {
            System.out.println(b.getBackTime());
        }
    }
}