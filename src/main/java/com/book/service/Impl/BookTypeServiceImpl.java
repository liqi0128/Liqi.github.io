package com.book.service.Impl;

import com.book.dao.BookTypeMapper;
import com.book.exceptional.NameException;
import com.book.pojo.Booktype;
import com.book.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public List<Booktype> getListBookType() {
        return bookTypeMapper.getBookTypeList();
    }

    @Override
    public boolean ModifyBookType(Booktype booktype) {
        int i= bookTypeMapper.setBookTypeModify(booktype);
        if(i == 1){return true;}
        return false;
    }

    @Override
    public boolean BookTypeAdd(Booktype booktype) throws NameException {
        if(bookTypeMapper.getBookTpye(booktype) != null){
            throw new NameException("图书类型名字已存在！");
        }
        if(bookTypeMapper.AddBookType(booktype) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean BookTypeDel(Integer id) {
        int i = bookTypeMapper.DelBookType(id);
        if(i==1){return true;}
        return false;
    }
}
