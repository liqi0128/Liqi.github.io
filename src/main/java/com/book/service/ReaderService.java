package com.book.service;

import com.book.exceptional.NameException;
import com.book.pojo.Reader;

import java.util.List;

public interface ReaderService {
    /**读者档案列表*/
    public List<Reader> getReaderList();
    /**档案详情*/
    public Reader getReaderId(Integer id);
    /**修改*/
    public boolean setReaderModify(Reader reader);
    /**添加*/
    public boolean ReaderAdd(Reader reader)throws NameException;
    /**删除*/
    public boolean ReaderDel(Integer id);
    /**根据条形码查询读者信息*/
    public Reader getReaderCode(String bercode);
}
