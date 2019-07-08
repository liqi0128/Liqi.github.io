package com.book.service;

import com.book.exceptional.NameException;
import com.book.pojo.Borrow;
import com.book.pojo.Giveback;

import java.util.List;
import java.util.Map;

public interface BookBorrowService {
    /**借阅排行*/
    public List<Borrow> getLoanRanking();
    /**添加借阅信息*/
    public boolean AddBorrow(Borrow borrow) throws NameException;
    /**读者借阅列表*/
    public List<Borrow> getListRenew(Integer readerid);
    /**续借更新到期时间*/
    public boolean setBorrowTime(Borrow borrow);
    /**图书归还*/
    public boolean setGiveback(Giveback giveback);
    /**图书借阅查询*/
    public List<Borrow> getBorrowQuery(Map map);
    /**借阅到期提醒*/
    public List<Borrow> getbremind();
}
