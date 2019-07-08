package com.book.dao;

import com.book.pojo.Manager;
import com.book.pojo.Purview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {
    /**获取用户权限列表*/
    public List<Manager> ManagerPurviewList();
    /**根据id查询用户权限*/
    public Manager PurviewID(@Param("id") Integer id);
    /**修改用户权限*/
    public int PurviewModify(Purview purview);
    /**用户删除*/
    public int ManagerDel(@Param("id") Integer id);
    /**用户权限删除*/
    public int PurviewDel(@Param("id") Integer id);
    /**添加用户*/
    public int addManager(Manager manager);
    /**添加用户权限*/
    public int addPurview(Purview purview);
    /**查询用户是否存在*/
    public Manager selectManager(Manager manager);


}
