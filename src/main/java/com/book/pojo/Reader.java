package com.book.pojo;

import com.book.util.DateFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**读者档案*/
public class Reader {

    private Integer id;
    private String name;
    private String sex;
    private String barcode;
    private String vocation;
    //解决后台类型为时间类型无法转换的问题
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String paperType;
    private String paperNO;
    private String tel;
    private String email;
    private Date createDate;
    private String operator;
    private String remark;
    private String typeid;

    private ReaderType readerType;

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    public String getBirthday() {
        if (this.birthday == null){return null;}
        return DateFormat.dateFormat(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperNO() {
        return paperNO;
    }

    public void setPaperNO(String paperNO) {
        this.paperNO = paperNO;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateDate() {
        if (this.createDate == null){return null;}

        return DateFormat.dateFormat(createDate);
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
}
