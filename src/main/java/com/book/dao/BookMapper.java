package com.book.dao;

import com.book.pojo.Bookinfo;
import com.book.pojo.Publishing;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    /**图书列表*/
    public List<Bookinfo> BookList();
    /**图书详情*/
    public  Bookinfo getBookinfo(@Param("id") Integer id);
    /**获取出版社列表*/
    public List<Publishing> publishingList();
    /**图书修改*/
    public int updateBookinfo(Bookinfo bookinfo);
    /**查询图书  是否存在*/
    public Bookinfo getBook(Bookinfo bookinfo);
    /**添加图书*/
    public int BookInfoAdd(Bookinfo bookinfo);
    /**删除*/
    public int delBookInfo(@Param("id") Integer id);
    /**借阅图书查询
     * 参数：条形码，图书名称
     * */
    public List<Bookinfo> selectBookInfo(Bookinfo bookinfo);
    /**动态查询，图书档案查询*/
    public List<Bookinfo> getBookQuery(Map<String,Object> query);
}
