package com.book.dao;

import com.book.pojo.Booktype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookTypeMapper {
    /**图书类型列表*/
    public List<Booktype> getBookTypeList();
    /**图书类型修改*/
    public int setBookTypeModify(Booktype booktype);
    /**查询图书类型*/
    public Booktype getBookTpye(Booktype booktype);
    /**添加*/
    public int AddBookType(Booktype booktype);
    /**删除*/
    public int DelBookType(@Param("id") Integer id);
}
