package com.book.controller;

import com.book.pojo.Borrow;
import com.book.pojo.Manager;
import com.book.pojo.ResultInfo;
import com.book.service.BookBorrowService;
import com.book.service.LoginOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("Manager")
public class LoginOutController {
    @Autowired
    private LoginOutService loginOutService;
    /**用户登陆*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    String Login(Manager manager, Model model, HttpServletRequest request){
        //添加加密码管理
        Manager m= loginOutService.Login(manager);
        if ( m==null) {
            model.addAttribute("out","登陆失败");
            return "login";
        } else {
            request.getSession().setAttribute("manager",m);
            return "redirect:main";
        }
    }
    @Autowired
    /**主页借阅列表*/
   private BookBorrowService bookBorrowService;
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    String main(Model model){

        List<Borrow> lists= bookBorrowService.getLoanRanking();
        if (lists.size()>5) {
           lists=lists.subList(0,5);
        }

        model.addAttribute("lists",lists);
        return "main";
    }
/**更改口令   验证原密码*/
@RequestMapping("oldpwd")
@ResponseBody
    public ResultInfo oldpwd(Manager manager){
        ResultInfo resultInfo;
        Manager m= loginOutService.Login(manager);
        if (m!=null){
            resultInfo=new ResultInfo(true,null,null);
        }else {
            resultInfo=new ResultInfo(false,null,null);
        }

        return resultInfo;
    }
    /***口令更改*/
    @RequestMapping("pwdModify")
    @ResponseBody
    public ResultInfo getPwdModify(Manager manager){
        ResultInfo resultInfo;
        if (loginOutService.pwdModify(manager)){
            resultInfo=new ResultInfo(true,null,null);
        }else {
            resultInfo=new ResultInfo(false,null,null);
        }

        return resultInfo;
    }
/***用户退出*/
    @RequestMapping("out")
    public String Out(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

}
