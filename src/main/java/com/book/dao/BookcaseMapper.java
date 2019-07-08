package com.book.dao;

import com.book.pojo.Bookcase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**书架板块*/
public interface BookcaseMapper {
    /**书架列表*/
    public List<Bookcase> BookcaseList();
    /**书架名称修改*/
    public int BookcaseModify(Bookcase bookcase);
    /**查询书架名称*/
    public Bookcase selectCaseName(Bookcase bookcase);
    /**添加书架*/
    public int BookcaseAdd(Bookcase bookcase);
    /**删除书架*/
    public int DelBookcase(@Param("id") Integer id);

}
