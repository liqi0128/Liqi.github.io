package com.book.controller;

import com.book.exceptional.UserNameException;
import com.book.pojo.Manager;
import com.book.pojo.Purview;
import com.book.pojo.ResultInfo;
import com.book.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    /**用户权限列表*/
    @RequestMapping("list")
    String ManagerPurview(HttpServletRequest request){
        List<Manager> list = managerService.getManagerPurviewList();
        request.getSession().setAttribute("ManList",list);
        return "redirect:/manager.jsp";
    }
    /**获取用户权限*/
    @RequestMapping(value = "/purview/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo PurviewModifyInfo(@PathVariable("id") Integer id){
        ResultInfo resultInfo;
        try {
            Manager manager=managerService.getPurviewID(id);
            resultInfo=new ResultInfo(true,manager,null);

        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
    /**修改用户权限*/
    @RequestMapping("modify")
    @ResponseBody
    public ResultInfo modifyPurview(Purview purview){

        ResultInfo resultInfo;
        boolean flag= false;
        try {
            flag = managerService.setPurviewModify(purview);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"用户权限修改失败！");
        }
        if (flag){
            resultInfo=new ResultInfo(true,null,"用户权限修改成功！");
        }else{
            resultInfo=new ResultInfo(false,null,"用户权限修改失败！");
        }
        return resultInfo;
    }
    /**删除用户*/
    @RequestMapping("del/{id}")
    @ResponseBody
    public ResultInfo delManager(@PathVariable("id") Integer id){
        ResultInfo resultInfo;
    if (managerService.delManager(id)){
        resultInfo=new ResultInfo(true,null,"用户删除成功！");
    }else{
        resultInfo=new ResultInfo(true,null,"用户删除失败！");
    }
        return resultInfo;
    }
    /**用户添加*/
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo addManager(Manager manager){
        ResultInfo resultInfo;
        try {
            if (managerService.addManager(manager)){
                resultInfo=new ResultInfo(true,null,"用户创建成功！");
            }else{
                resultInfo=new ResultInfo(true,null,"用户创建失败！");
            }
        } catch (UserNameException e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,e.getMessage());
        } catch (Exception e){
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
}
