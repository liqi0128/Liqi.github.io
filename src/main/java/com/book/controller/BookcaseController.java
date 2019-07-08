package com.book.controller;

import com.book.exceptional.CaseNameException;
import com.book.pojo.Bookcase;
import com.book.pojo.ResultInfo;
import com.book.service.BookcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("case")
public class BookcaseController {
    @Autowired
    private BookcaseService bookcaseService;
/**书架列表*/
    @RequestMapping("list")
    public String BookcaseList(HttpServletRequest request){
        List<Bookcase> list = bookcaseService.getBookcaseList();
        request.getSession().setAttribute("bookcaseList",list);
        return "redirect:/bookcase.jsp";
    }
/**书架修改*/
    @RequestMapping("modify")
    @ResponseBody
    public ResultInfo BookcaseModify(Bookcase bookcase){
        ResultInfo resultInfo;
        try {
            if (bookcaseService.UpdataBookcase(bookcase)){
                resultInfo= new ResultInfo(true,null,"书架名称修改成功！");
            }else {
                resultInfo= new ResultInfo(false,null,"书架名称修改失败！");
            }
        } catch (CaseNameException e) {
            e.printStackTrace();
            resultInfo= new ResultInfo(false,null,e.getMessage());
        } catch (Exception e){
            resultInfo= new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
    /**添加书架*/
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo bookcaseAdd(Bookcase bookcase){
        ResultInfo resultInfo;
        try {
            if (bookcaseService.AddBookcase(bookcase)){
                resultInfo= new ResultInfo(true,null,"书架添加成功！");
            }else {
                resultInfo= new ResultInfo(false,null,"书架添加失败！");
            }
        } catch (CaseNameException e) {
            e.printStackTrace();
            resultInfo= new ResultInfo(false,null,e.getMessage());
        } catch (Exception e){
            resultInfo= new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
    /**删除*/
    @RequestMapping("del/{id}")
    @ResponseBody
    public ResultInfo DelBookcase(@PathVariable("id") Integer id){
        ResultInfo resultInfo;
        try {
            if(bookcaseService.DelBookcase(id)){
                resultInfo=new ResultInfo(true,null,"删除成功！");
            }else{
                resultInfo=new ResultInfo(false,null,"删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
    /**异步请求书架列表*/
    @RequestMapping("caselist")
    @ResponseBody
    public ResultInfo getbookcaseList(){
        ResultInfo resultInfo;
        try {
            List<Bookcase> list = bookcaseService.getBookcaseList();
            resultInfo=new ResultInfo(true,list,null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }

}
