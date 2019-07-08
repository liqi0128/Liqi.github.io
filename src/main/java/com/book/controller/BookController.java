package com.book.controller;

import com.book.exceptional.NameException;
import com.book.pojo.Bookinfo;
import com.book.pojo.Manager;
import com.book.pojo.Publishing;
import com.book.pojo.ResultInfo;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
/**图书列表*/
    @RequestMapping("list")
    public String BookList(HttpServletRequest request){
        List<Bookinfo> list= bookService.ListBook();
        request.getSession().setAttribute("bookList",list);
        return "redirect:/book.jsp";
    }
    /**图书详情*/
    @RequestMapping("dateil/{id}")
    public String Bookdateil(@PathVariable("id") Integer id ,Model model){
        Bookinfo bookinfo = bookService.getBookInfo(id);
        model.addAttribute("book",bookinfo);
        return "book_detail";
    }
    /**跳转修改页面*/
    @RequestMapping("modify/{id}")
    public String BookModify(@PathVariable("id") Integer id ,HttpServletRequest request){
        Bookinfo bookinfo = bookService.getBookInfo(id);
        request.getSession().setAttribute("book",bookinfo);
        return "redirect:/book_Modify.jsp";
    }
    /**获取出版社列表*/
    @RequestMapping("pub")
    @ResponseBody
    public ResultInfo getpublishing(){
        ResultInfo resultInfo;
        try {
            List<Publishing> list = bookService.getPublishingList();
            resultInfo=new ResultInfo(true,list,null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
/**图书信息修改*/
    @RequestMapping("modify")
    @ResponseBody
    public ResultInfo getBookModify(Bookinfo bookinfo){
        ResultInfo resultInfo;
        if (bookService.UpdateBookInfo(bookinfo)){
            resultInfo=new ResultInfo(true,null,"修改成功！");
        }else {
            resultInfo=new ResultInfo(false,null,"修改失败！");
        }

        return resultInfo;
    }
    /**添加*/
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo BookAdd(Bookinfo bookinfo,HttpServletRequest request){
        ResultInfo resultInfo;
        Manager manager= (Manager) request.getSession().getAttribute("manager");
        bookinfo.setOperator(manager.getName());
        bookinfo.setInTime(new Date());
        try {
            if(bookService.AddBookInfo(bookinfo)){
                resultInfo = new ResultInfo(true,null,"添加成功！");
            }else {
                resultInfo =new ResultInfo(false,null,"添加失败！");
            }
        } catch (NameException e) {
            e.printStackTrace();
            resultInfo =new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
    /**删除*/
    @RequestMapping("del/{id}")
    @ResponseBody
    public ResultInfo delBookInfo(@PathVariable("id") Integer id){
        ResultInfo resultInfo;
        if (bookService.BookInfoDel(id)){
            resultInfo=new ResultInfo(true,null,"删除成功！");
        }else {
            resultInfo=new ResultInfo(false,null,"删除失败！");
        }

        return resultInfo;
    }
    /**异步查询图书   参数：条形码，图书名称*/
    @RequestMapping("info")
    @ResponseBody
    public ResultInfo getselectBook(@RequestParam("radio") String radio,@RequestParam("inputkey") String inputkey){
        Bookinfo bookinfo=new Bookinfo();
        ResultInfo resultInfo;
        if (radio.equals("barcode")){
            bookinfo.setBarcode(inputkey);
        }else {
            bookinfo.setBookname(inputkey);
        }
        List<Bookinfo> list = bookService.selectBookInfo(bookinfo);
        if (list.size() !=0){
            resultInfo =new ResultInfo(true,list,null);
        }else {
            resultInfo = new ResultInfo(false,null,"未找到！");
        }
        return resultInfo;
    }
    /**图书档案查询*/
    @RequestMapping("query")
    @ResponseBody
    public ResultInfo getBookQuery(@RequestParam(value = "key",required = false) String key,@RequestParam(value = "value",required = false) String value){
        ResultInfo resultInfo;
        Map<String,Object> m=new HashMap();
        m.put(key,value);
        List<Bookinfo> list = bookService.getBookQuery(m);
        if(list.size() != 0){
            resultInfo =new ResultInfo(true,list,null);
        }else {
            resultInfo=new ResultInfo(false,null,null);
        }

        return resultInfo;
    }

}
