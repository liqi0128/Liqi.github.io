package com.book.service.Impl;

import com.book.dao.BookMapper;
import com.book.exceptional.NameException;
import com.book.pojo.Bookinfo;
import com.book.pojo.Publishing;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Bookinfo> ListBook() {
        return bookMapper.BookList();
    }

    @Override
    public Bookinfo getBookInfo(Integer id) {
        return bookMapper.getBookinfo(id);
    }

    @Override
    public List<Publishing> getPublishingList() {
        return bookMapper.publishingList();
    }

    @Override
    public boolean UpdateBookInfo(Bookinfo bookinfo) {
        int i =bookMapper.updateBookinfo(bookinfo);
        if(i==1){return true;}
        return false;
    }

    @Override
    public boolean AddBookInfo(Bookinfo bookinfo) throws NameException {
        if (bookMapper.getBook(bookinfo) != null){
            throw new NameException("该书已存在！");
        }
        int i=bookMapper.BookInfoAdd(bookinfo);
        if (i==1){return true;}
        return false;
    }

    @Override
    public boolean BookInfoDel(Integer id) {
        int i = bookMapper.delBookInfo(id);
        if(i==1){return true;}
        return false;
    }

    @Override
    public List<Bookinfo> selectBookInfo(Bookinfo bookinfo) {
        return bookMapper.selectBookInfo(bookinfo);
    }

    @Override
    public List<Bookinfo> getBookQuery(Map<String, Object> query) {
        return bookMapper.getBookQuery(query);
    }
}
