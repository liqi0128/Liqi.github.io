package com.book.service;

import com.book.exceptional.NameException;
import com.book.pojo.Bookinfo;
import com.book.pojo.Publishing;

import java.util.List;
import java.util.Map;

public interface BookService {
    /**图书列表*/
    public List<Bookinfo> ListBook();
    /**图书详情*/
    public Bookinfo getBookInfo(Integer id);
    /**出版社列表*/
    public List<Publishing> getPublishingList();
    /**图书修改*/
    public boolean UpdateBookInfo(Bookinfo bookinfo);
    /**添加*/
    public boolean AddBookInfo(Bookinfo bookinfo) throws NameException;
    /**删除*/
    public boolean BookInfoDel(Integer id);
    /**借阅查询*/
    public List<Bookinfo> selectBookInfo(Bookinfo bookinfo);
    /**图书档案查询*/
    public List<Bookinfo> getBookQuery(Map<String,Object> query);
}
