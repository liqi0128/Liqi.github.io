package com.book.dao;

import com.book.pojo.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderMapper {
    /**获取读者档案列表*/
    public List<Reader> readerList();
    /**读者档案详情*/
    public Reader readerId(@Param("id") Integer id);
    /**修改*/
    public int updateReader(Reader reader);
    /**查询名字*/
    public  Reader getReaderName(Reader reader);
    /**添加*/
    public int AddReader(Reader reader);
    /**删除*/
    public int DelReader(@Param("id") Integer id);
    /**根据读者条形码查询读者信息*/
    public Reader ReaderCode(@Param("bercode") String bercode);
}
