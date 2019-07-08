package com.book.service.Impl;

import com.book.dao.LoginOutMapper;
import com.book.pojo.Manager;
import com.book.service.LoginOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginOutServiceImpl implements LoginOutService{
    @Autowired
    private LoginOutMapper loginOutMapper;

    @Override
    public Manager Login(Manager manager) {
        return loginOutMapper.Login(manager);
    }

    @Override
    public boolean pwdModify(Manager manager) {
        if(loginOutMapper.pwdModify(manager) == 1){return true;}
        return false;
    }
}
