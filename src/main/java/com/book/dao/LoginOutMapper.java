package com.book.dao;

import com.book.pojo.Manager;

public interface LoginOutMapper {
    /**用户验证登陆*/
    public Manager Login(Manager manager);
    /**更改口令*/
    public int pwdModify(Manager manager);

}
