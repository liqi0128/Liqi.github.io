package com.book.service;

import com.book.exceptional.UserNameException;
import com.book.pojo.Manager;
import com.book.pojo.Purview;

import java.util.List;

public interface ManagerService {
    /**用户权限列表*/
    public List<Manager> getManagerPurviewList();
    /**根据id查询用户权限*/
    public Manager getPurviewID(Integer id);
    /**更新用户权限*/
    public boolean setPurviewModify(Purview purview);
    /**删除用户*/
    public boolean delManager(Integer id);
    /**添加用户默认权限4条*/
    public boolean addManager(Manager manager)throws UserNameException;
}
