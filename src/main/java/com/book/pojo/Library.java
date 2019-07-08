package com.book.pojo;

import com.book.util.DateFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**图书馆信息*/
public class Library {
    private Integer id;
    private String libraryname;
    private String curator;
    private String tel;
    private String address;
    private String email;
    private String url;
    //解决后台类型为时间类型无法转换的问题
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate;
    private String introduce;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibraryname() {
        return libraryname;
    }

    public void setLibraryname(String libraryname) {
        this.libraryname = libraryname;
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getCreateDate() {
if (this.createDate == null){return null;}
        return DateFormat.dateFormat(createDate) ;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
