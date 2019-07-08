package com.book.dao;

import com.book.pojo.ReaderType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderTypeMapper {
    /**读者类型列表*/
    public List<ReaderType> readerTypeList();
    /**查询读者类型   名字*/
    public ReaderType selectReaderType(ReaderType readerType);
    /**修改读者类型*/
    public int updataReaderType(ReaderType readerType);
    /**添加读者类型*/
    public int addReaderType(ReaderType readerType);
    /**删除*/
    public int delReaderType(@Param("id") Integer id);
}
