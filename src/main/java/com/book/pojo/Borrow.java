package com.book.pojo;
/**借阅信息*/

import java.util.Date;

public class Borrow {

	private Integer id;
	private Integer readerid;
	private Integer bookid;
	private Date borrowTime;
	private Date backTime;
	private String operator;
	private Integer ifback;

	private  Integer count;//个图书借阅数量

	private Bookinfo bookinfo;//图书信息
	private Bookcase bookcase;//书架
	private Publishing publishing;//出版社
	private Booktype booktype;//图书类型
	private Reader reader;//读者

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Bookinfo getBookinfo() {
		return bookinfo;
	}

	public void setBookinfo(Bookinfo bookinfo) {
		this.bookinfo = bookinfo;
	}

	public Bookcase getBookcase() {
		return bookcase;
	}

	public void setBookcase(Bookcase bookcase) {
		this.bookcase = bookcase;
	}

	public Publishing getPublishing() {
		return publishing;
	}

	public void setPublishing(Publishing publishing) {
		this.publishing = publishing;
	}

	public Booktype getBooktype() {
		return booktype;
	}

	public void setBooktype(Booktype booktype) {
		this.booktype = booktype;
	}

	public Integer getId() {
		return id;
	}
	public Integer getReaderid() {
		return readerid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public Date getBackTime() {
		return backTime;
	}
	public String getOperator() {
		return operator;
	}
	public Integer getIfback() {
		return ifback;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setIfback(Integer ifback) {
		this.ifback = ifback;
	}
	
	
	
}
