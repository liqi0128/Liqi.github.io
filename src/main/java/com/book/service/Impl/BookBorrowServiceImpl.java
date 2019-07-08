package com.book.service.Impl;

import com.book.dao.BookBorrowMapper;
import com.book.exceptional.NameException;
import com.book.pojo.Borrow;
import com.book.pojo.Giveback;
import com.book.service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Override
    public List<Borrow> getLoanRanking() {
        return bookBorrowMapper.LoanRanking();
    }

    @Override
    public boolean AddBorrow(Borrow borrow) throws NameException {
        Borrow borrow1=bookBorrowMapper.getBookBorrow(borrow);
        if(borrow1 != null){throw new NameException("该书已借阅！");}
        int i= bookBorrowMapper.BookBorrowAdd(borrow);
        if(i == 1){return true;}
        return false;
    }

    @Override
    public List<Borrow> getListRenew(Integer readerid) {
        return bookBorrowMapper.getBookRenewList(readerid);
    }

    @Override
    public boolean setBorrowTime(Borrow borrow) {
        int i = bookBorrowMapper.BorrowBackTime(borrow);
        if(i==1){return true;}
        return false;
    }

    @Override
    public boolean setGiveback(Giveback giveback) {
        int i=bookBorrowMapper.setBorrowifback(giveback.getId());
        int j = bookBorrowMapper.setAddGiveback(giveback);
        if(i==1 && j==1){return true;}
        return false;
    }

    @Override
    public List<Borrow> getBorrowQuery(Map map) {
        return bookBorrowMapper.getBorrowQuery(map);
    }

    @Override
    public List<Borrow> getbremind() {
        return bookBorrowMapper.getBremind(new Date());
    }
}
