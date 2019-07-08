package com.book.service.Impl;

import com.book.dao.BookcaseMapper;
import com.book.exceptional.CaseNameException;
import com.book.pojo.Bookcase;
import com.book.service.BookcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookcaseServiceImpl implements BookcaseService {
    @Autowired
    private BookcaseMapper bookcaseMapper;

    @Override
    public List<Bookcase> getBookcaseList() {
        return bookcaseMapper.BookcaseList();
    }

    @Override
    public boolean UpdataBookcase(Bookcase bookcase) throws CaseNameException {
        Bookcase bookcase1=bookcaseMapper.selectCaseName(bookcase);
        if(bookcase1 != null){
            throw new CaseNameException("书架名称已存在！");
        }
        int i =bookcaseMapper.BookcaseModify(bookcase);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean AddBookcase(Bookcase bookcase) throws CaseNameException {
        Bookcase bookcase1=bookcaseMapper.selectCaseName(bookcase);
        if(bookcase1 != null){
            throw new CaseNameException("书架名称已存在！");
        }
        int i =bookcaseMapper.BookcaseAdd(bookcase);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean DelBookcase(Integer id) {
        int i= bookcaseMapper.DelBookcase(id);
        if(i == 1){
            return true;
        }
        return false;
    }
}
