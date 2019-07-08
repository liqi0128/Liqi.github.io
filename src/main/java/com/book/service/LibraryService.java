package com.book.service;

import com.book.pojo.Library;

public interface LibraryService {
    /**图书馆信息*/
    public Library getLibraryInformation();
    /**修改图书馆信息*/
    public int getLibraryModify(Library library);
}
