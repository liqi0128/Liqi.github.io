package com.book.service;

import com.book.exceptional.CaseNameException;
import com.book.pojo.Bookcase;

import java.util.List;

public interface BookcaseService {
    /**书架列表*/
    public List<Bookcase> getBookcaseList();
    /**修改书架名称*/
    public boolean UpdataBookcase(Bookcase bookcase) throws CaseNameException;
    /**添加书架*/
    public boolean AddBookcase(Bookcase bookcase) throws CaseNameException;
    /**删除书架*/
    public boolean DelBookcase(Integer id);
}
