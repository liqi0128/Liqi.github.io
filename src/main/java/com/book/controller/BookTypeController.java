package com.book.controller;

import com.book.exceptional.NameException;
import com.book.pojo.Booktype;
import com.book.pojo.ResultInfo;
import com.book.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("bookType")
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;
/**图书类型列表*/
    @RequestMapping("list")
    public String BookTypeList(HttpServletRequest request){
        List<Booktype> list = bookTypeService.getListBookType();
        request.getSession().setAttribute("bookTypeList",list);
        return "redirect:/bookType.jsp";
    }
/**修改*/
    @RequestMapping("modify")
    @ResponseBody
    public ResultInfo bookTypeModify(Booktype booktype){
        ResultInfo resultInfo;
        try {
            if (bookTypeService.ModifyBookType(booktype)){
                resultInfo= new ResultInfo(true,null,"图书类型修改成功！");
            }else{
                resultInfo = new ResultInfo(false,null,"图书类型修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
/**添加*/
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo bookTypeAdd(Booktype booktype){
        ResultInfo resultInfo;
        try {
            if(bookTypeService.BookTypeAdd(booktype)){
                resultInfo= new ResultInfo(true,null,"添加成功！");
            }else{
                resultInfo= new ResultInfo(false,null,"添加失败！");
            }

        } catch (NameException e) {
            e.printStackTrace();
            resultInfo= new ResultInfo(false,null,e.getMessage());
        } catch(Exception e){
            resultInfo= new ResultInfo(false,null,"服务异常！");
        }

        return resultInfo;
    }

    /**删除*/
    @RequestMapping("del/{id}")
    @ResponseBody
    public ResultInfo bookType(@PathVariable("id") Integer id){
        ResultInfo resultInfo;
        if(bookTypeService.BookTypeDel(id)){
            resultInfo=new ResultInfo(true,null,"删除成功！");
        }else {
            resultInfo=new ResultInfo(false,null,"删除失败！");
        }

        return resultInfo;
    }
    /***异步请求图书类型列表*/
    @RequestMapping("typelist")
    @ResponseBody
    public ResultInfo getbookTypeList(){
        ResultInfo resultInfo;
        try {
            List<Booktype> list = bookTypeService.getListBookType();
            resultInfo =new ResultInfo(true,list,null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo =new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
}
