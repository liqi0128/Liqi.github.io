package com.book.controller;

import com.book.exceptional.NameException;
import com.book.pojo.ReaderType;
import com.book.pojo.ResultInfo;
import com.book.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("readerType")
public class ReaderTypeController {
    @Autowired
    private ReaderTypeService readerTypeService;
/**读者类型列表*/
    @RequestMapping("list")
    public String ReaderTypeList(HttpServletRequest request){
        List<ReaderType> list = readerTypeService.getReaderType();
        request.getSession().setAttribute("readerType",list);
        return "redirect:/readerType.jsp";
    }

    /**修改*/
    @RequestMapping("modify")
    @ResponseBody
    public ResultInfo readerModify(ReaderType readerType){
        ResultInfo resultInfo;

            if (readerTypeService.ReaderTypeModify(readerType)){
                resultInfo= new ResultInfo(true,null,"读者类型修改成功！");
            }else {
                resultInfo= new ResultInfo(false,null,"读者类型修改失败！");
            }

        return resultInfo;
    }
    /**添加*/
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo ReaderTypeAdd(ReaderType readerType){
        ResultInfo resultInfo;
        try {
            if(readerTypeService.ReaderTypeAdd(readerType)){
                resultInfo= new ResultInfo(true,null,"读者类型添加成功！");
            }else{
                resultInfo= new ResultInfo(false,null,"读者类型添加失败！");
            }
        } catch (NameException e) {
            e.printStackTrace();
            resultInfo= new ResultInfo(false,null,e.getMessage());
        }
        return resultInfo;
    }
    /**删除*/
    @RequestMapping("del/{id}")
    @ResponseBody
    public ResultInfo delReaderType(@PathVariable("id") Integer id){
        ResultInfo resultInfo;
        if(readerTypeService.ReaderTypeDel(id)){
            resultInfo=new ResultInfo(true,null,"读者类型删除成功！");
        }else{
            resultInfo=new ResultInfo(false,null,"读者类型删除失败！");
        }

        return resultInfo;
    }
    /**异步请求读者类型列表*/
    @RequestMapping("typeList")
    @ResponseBody
    public ResultInfo TypeList(){
        ResultInfo resultInfo;

        try {
            List<ReaderType> list = readerTypeService.getReaderType();
            resultInfo=new ResultInfo(true,list,null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }

        return resultInfo;
    }
}
