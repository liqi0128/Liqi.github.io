package com.book.service.Impl;

import com.book.dao.LibraryMapper;
import com.book.pojo.Library;
import com.book.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public Library getLibraryInformation() {
        return libraryMapper.LibraryInformation();
    }

    @Override
    public int getLibraryModify(Library library) {
        return libraryMapper.LibraryModify(library);
    }
}
