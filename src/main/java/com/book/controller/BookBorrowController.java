package com.book.controller;

import com.book.exceptional.NameException;
import com.book.pojo.Borrow;
import com.book.pojo.Giveback;
import com.book.pojo.Manager;
import com.book.pojo.ResultInfo;
import com.book.service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("borrow")
public class BookBorrowController {
    @Autowired
    private BookBorrowService bookBorrowService;

    /**借阅排行榜*/
    @RequestMapping("sort")
    public String getBorrowSort(Model model){
        List<Borrow> list = bookBorrowService.getLoanRanking();
        model.addAttribute("borrowList",list);
        return "bookBorrowSort";
    }
    /**借阅*/
    @RequestMapping("borrowadd")
    @ResponseBody
    public ResultInfo getBookBorrow(Borrow borrow, HttpServletRequest request){
        Manager manager= (Manager) request.getSession().getAttribute("manager");
        borrow.setOperator(manager.getName());
        borrow.setIfback(0);
        ResultInfo resultInfo;


        try {
            if(bookBorrowService.AddBorrow(borrow)){
                resultInfo=new ResultInfo(true,null,"借阅成功！");
            }else {
                resultInfo=new ResultInfo(false,null,"借阅失败！");
            }
        } catch (NameException e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,e.getMessage());
        }catch (Exception e){
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }


        return resultInfo;
    }
    /**读者借阅列表*/
    @RequestMapping("borrowList/{readerid}")
    @ResponseBody
    public ResultInfo getBookBorrowList(@PathVariable("readerid") Integer readerid){
        ResultInfo resultInfo;
        List<Borrow> list = bookBorrowService.getListRenew(readerid);

        try {
            if(list.size() !=0){
                resultInfo=new ResultInfo(true,list,null);
            }else {
                resultInfo=new ResultInfo(false,null,"读者暂无借阅图书！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }

        return resultInfo;
    }
    /**图书续借*/
    @RequestMapping("renew")
    @ResponseBody
    public ResultInfo getBorrowRenew(Borrow borrow){
        ResultInfo resultInfo;
        if (bookBorrowService.setBorrowTime(borrow)){
            resultInfo = new ResultInfo(true,null,"续借成功！");
        }else {
            resultInfo = new ResultInfo(false,null,"续借失败！");
        }

        return resultInfo;
    }
    /**图书归还*/
    @RequestMapping("back")
    @ResponseBody
    public ResultInfo getBookBack(Giveback giveback,HttpServletRequest request){
        ResultInfo resultInfo;
        Manager manager= (Manager) request.getSession().getAttribute("manager");
        giveback.setOperator(manager.getName());
        giveback.setBackTime(new Date());
        if(bookBorrowService.setGiveback(giveback)){
            resultInfo=new ResultInfo(true,null,"归还成功！");
        }else {
            resultInfo=new ResultInfo(false,null,"归还失败！");
        }

        return resultInfo;

    }
    /**图书借阅查询*/
    @RequestMapping("query")
    @ResponseBody
    public ResultInfo getBorrowQuery(@RequestParam(value = "key",required = false) String key, @RequestParam(value = "value",required = false) String value,
                                     @RequestParam( value ="sdate",required = false) @DateTimeFormat(pattern="yyyy-MM-dd")Date sdate,
                                     @RequestParam(value = "edate",required = false) @DateTimeFormat(pattern="yyyy-MM-dd")Date edate){
        ResultInfo resultInfo;
        Map<String,Object> map = new HashMap<>();
        map.put(key,value);
        map.put("sdate",sdate);
        map.put("edate",edate);
        List<Borrow> list = bookBorrowService.getBorrowQuery(map);
        if (list.size() != 0){
            resultInfo = new ResultInfo(true,list,null);
        }else {
            resultInfo = new ResultInfo(false,null,null);
        }
        return resultInfo;
    }
    /**借阅到期提醒*/
    @RequestMapping("bremind")
    @ResponseBody
    public ResultInfo getbremind(){
        ResultInfo resultInfo;
        List<Borrow> list = bookBorrowService.getbremind();
        if(list.size()!=0){
            resultInfo = new ResultInfo(true,list,null);
        }else {
            resultInfo = new ResultInfo(false,null,null);
        }

    return resultInfo;
    }
}
