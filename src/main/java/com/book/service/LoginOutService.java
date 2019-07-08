package com.book.service;

import com.book.pojo.Manager;

public interface LoginOutService {
/**用户登陆验证*/
public Manager Login(Manager manager);
/**更改口令*/
public boolean pwdModify(Manager manager);
}
