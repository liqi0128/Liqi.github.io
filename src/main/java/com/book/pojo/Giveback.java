package com.book.pojo;

import java.util.Date;

public class Giveback {
    private Integer id;
    private Integer readerid;
    private Integer bookid;
    private Date backTime;
    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
