package com.book.pojo;
/**用户权限*/
public class Purview {
private Integer id;
private Integer sysset;
private Integer readerset;
private Integer  bookset;
private Integer borrowback;
private Integer sysquery;

public Integer getId() {
	return id;
}
public Integer getSysset() {
	return sysset;
}
public Integer getReaderset() {
	return readerset;
}
public Integer getBookset() {
	return bookset;
}
public Integer getBorrowback() {
	return borrowback;
}
public Integer getSysquery() {
	return sysquery;
}
public void setId(Integer id) {
	this.id = id;
}
public void setSysset(Integer sysset) {
	this.sysset = sysset;
}
public void setReaderset(Integer readerset) {
	this.readerset = readerset;
}
public void setBookset(Integer bookset) {
	this.bookset = bookset;
}
public void setBorrowback(Integer borrowback) {
	this.borrowback = borrowback;
}
public void setSysquery(Integer sysquery) {
	this.sysquery = sysquery;
}

}
