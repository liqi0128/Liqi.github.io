package com.book.service.Impl;

import com.book.dao.ReaderTypeMapper;
import com.book.exceptional.NameException;
import com.book.pojo.ReaderType;
import com.book.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderTypeServiceImpl implements ReaderTypeService {
    @Autowired
    private ReaderTypeMapper readerTypeMapper;

    @Override
    public List<ReaderType> getReaderType() {
        return readerTypeMapper.readerTypeList();
    }

    @Override
    public boolean ReaderTypeModify(ReaderType readerType) {
            int i =readerTypeMapper.updataReaderType(readerType);
            if (i == 1){return true;}
        return false;
    }

    @Override
    public boolean ReaderTypeAdd(ReaderType readerType) throws NameException {
        if(readerTypeMapper.selectReaderType(readerType) != null){
            throw new NameException("读者类型名称已存在！");
        }
         int i= readerTypeMapper.addReaderType(readerType);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean ReaderTypeDel(Integer id) {
        int i=readerTypeMapper.delReaderType(id);
        if (i == 1){
            return true;
        }
        return false;
    }
}
