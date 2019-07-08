package com.book.service;

import com.book.exceptional.NameException;
import com.book.pojo.ReaderType;

import java.util.List;

public interface ReaderTypeService {
    /**获取读者列表*/
    public List<ReaderType> getReaderType();
    /**修改读者类型*/
    public boolean ReaderTypeModify(ReaderType readerType);
    /**添加读者类型*/
    public  boolean ReaderTypeAdd(ReaderType readerType) throws NameException;
    /**删除*/
    public boolean ReaderTypeDel(Integer id);
}
