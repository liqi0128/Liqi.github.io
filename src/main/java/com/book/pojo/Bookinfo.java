package com.book.pojo;

import com.book.util.DateFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**图书信息*/
public class Bookinfo {

	private Integer id;
	private String barcode;
	private String bookname;
	private Integer typeid;
	private String author;
	private String translator;
	private String ISBN;
	private Float price;
	private Integer page;
	private Integer bookcase;
	//解决后台类型为时间类型无法转换的问题
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date inTime;
	private String operator;
	private Integer del;


	private Bookcase bookCase;//书架
	private Publishing publishing;//出版社
	private Booktype booktype;//图书类型




	public Bookcase getBookCase() {
		return bookCase;
	}

	public void setBookCase(Bookcase bookCase) {
		this.bookCase = bookCase;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getBookcase() {
		return bookcase;
	}

	public void setBookcase(Integer bookcase) {
		this.bookcase = bookcase;
	}

	public String getInTime() {
		if (this.inTime == null){return null;}
		return DateFormat.dateFormat(this.inTime);
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

}
