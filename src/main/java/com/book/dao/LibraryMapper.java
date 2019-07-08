package com.book.dao;

import com.book.pojo.Library;

public interface LibraryMapper {
    /**查询图书馆信息*/
    public Library LibraryInformation();
    /**修改图书馆信息*/
    public int LibraryModify(Library library);


}
