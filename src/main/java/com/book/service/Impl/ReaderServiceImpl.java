package com.book.service.Impl;

import com.book.dao.BookBorrowMapper;
import com.book.dao.ReaderMapper;
import com.book.exceptional.NameException;
import com.book.pojo.Reader;
import com.book.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public List<Reader> getReaderList() {
        return readerMapper.readerList();
    }

    @Override
    public Reader getReaderId(Integer id) {
        return readerMapper.readerId(id);
    }

    @Override
    public boolean setReaderModify(Reader reader) {
        int i = readerMapper.updateReader(reader);
        if(i == 1){return true;}
        return false;
    }

    @Override
    public boolean ReaderAdd(Reader reader) throws NameException {
        if(readerMapper.getReaderName(reader) != null){
            throw new NameException("读者名字已存在！");
        }
        int i = readerMapper.AddReader(reader);
        if (i==1){return true;}
        return false;
    }

    @Override
    public boolean ReaderDel(Integer id) {
        int i= readerMapper.DelReader(id);
        if (i == 1){return true;}
        return false;
    }


    @Autowired
    private BookBorrowMapper bookBorrowMapper;
    public Reader getReaderCode(String bercode) {
        Reader reader= readerMapper.ReaderCode(bercode);
        if(reader != null){
            int count=bookBorrowMapper.ConutBorrw(reader.getId());
            int count1=reader.getReaderType().getNumber()-count;//计算可借数量
            reader.getReaderType().setNumber(count1);
        }
        return reader;
    }
}
