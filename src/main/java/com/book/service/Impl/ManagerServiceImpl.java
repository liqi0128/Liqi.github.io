package com.book.service.Impl;

import com.book.dao.ManagerMapper;
import com.book.exceptional.UserNameException;
import com.book.pojo.Manager;
import com.book.pojo.Purview;
import com.book.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public List<Manager> getManagerPurviewList() {
        return managerMapper.ManagerPurviewList();
    }

    @Override
    public Manager getPurviewID(Integer id) {
        return managerMapper.PurviewID(id);
    }
/**更新用户权限*/
    @Override
    public boolean setPurviewModify(Purview purview) {
        int i=managerMapper.PurviewModify(purview);
        if (i==1){
            return true;
        }
        return false;
    }
/**删除用户*/
    @Override
    public boolean delManager(Integer id) {
        int i = managerMapper.ManagerDel(id);
        int j = managerMapper.PurviewDel(id);
        if (i==1||j==1){
            return true;
        }
        return false;
    }
/**用户添加   添加异常名字判断*/
    @Override
    public boolean addManager(Manager manager) throws UserNameException {
        Manager manager2=managerMapper.selectManager(manager);
        if (manager2 != null){
            throw new UserNameException("用户已存在!");
        }
        int i= managerMapper.addManager(manager);
        if (i==1) {
        Manager manager1=managerMapper.selectManager(manager);
        Purview purview =new Purview();
        purview.setId(manager1.getId());
        purview.setSysset(0);
        purview.setReaderset(1);
        purview.setBookset(1);
        purview.setBorrowback(1);
        purview.setSysquery(1);
        i=managerMapper.addPurview(purview);
        if (i==1){
            return true;
        }
        }
        return false;
    }
}
