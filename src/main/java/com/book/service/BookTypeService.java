package com.book.service;

import com.book.exceptional.NameException;
import com.book.pojo.Booktype;

import java.util.List;

public interface BookTypeService {
    /**图书类型列表*/
    public List<Booktype> getListBookType();
    /**图书类型修改*/
    public boolean ModifyBookType(Booktype booktype);
    /**添加*/
    public boolean BookTypeAdd(Booktype booktype)throws NameException;
    /**删除*/
    public boolean BookTypeDel(Integer id);
}
