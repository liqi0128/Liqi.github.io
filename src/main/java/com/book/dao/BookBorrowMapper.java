package com.book.dao;

import com.book.pojo.Borrow;
import com.book.pojo.Giveback;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookBorrowMapper {
    /**图书借阅排行*/
    public List<Borrow> LoanRanking();
    /**统计该读者借阅数量*/
    public int ConutBorrw(@Param("readerid") Integer readerid);
    /**判断该图书是否已借阅*/
    public Borrow getBookBorrow(Borrow borrow);
    /**添加借阅信息*/
    public int BookBorrowAdd(Borrow borrow);
    /**读者借阅列表*/
    public List<Borrow> getBookRenewList(@Param("readerid") Integer readerid);
    /**续借更新到期时间*/
    public int BorrowBackTime(Borrow borrow);
    /**归还 更新borrow表的ifback字段*/
    public int setBorrowifback(@Param("id") Integer id);
    /**添加归还信息*/
    public int setAddGiveback(Giveback giveback);
    /**图书借阅查询*/
    public List<Borrow> getBorrowQuery(Map map);
    /**借阅到期提醒*/
    public List<Borrow> getBremind(@Param("back")Date back);

}
