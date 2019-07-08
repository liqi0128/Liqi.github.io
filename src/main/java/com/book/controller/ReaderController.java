package com.book.controller;

import com.book.exceptional.NameException;
import com.book.pojo.Manager;
import com.book.pojo.Reader;
import com.book.pojo.ResultInfo;
import com.book.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("reader")
public class ReaderController {
    @Autowired
    private ReaderService readerService;
/*读者档案列表*/
    @RequestMapping("list")
    public String ReaderList(HttpServletRequest request){
        List<Reader> list = readerService.getReaderList();
        request.getSession().setAttribute("readerList",list);
        return "redirect:/reader.jsp";
    }
    /**档案详情*/
    @RequestMapping("detail/{id}")
    public String ReaderDetail(Model model, @PathVariable("id") Integer id ){
        Reader reader = readerService.getReaderId(id);
        model.addAttribute("reader",reader);
        return "reader_detail";
    }
    /**读者档案修改页面*/
    @RequestMapping("modify/{id}")
    public String readerModify( @PathVariable("id") Integer id ,HttpServletRequest request){
        Reader reader = readerService.getReaderId(id);
        request.getSession().setAttribute("reader",reader);
        return "redirect:/reader_Modify.jsp";
    }
    /**修改*/
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateReader(Reader reader){

        ResultInfo resultInfo;
        try {
            if(readerService.setReaderModify(reader)){
                resultInfo=new ResultInfo(true,null,"读者档案修改成功！");
            }else {
                resultInfo=new ResultInfo(false,null,"读者档案修改成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
    /**添加*/
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo ReaderAdd(Reader reader,HttpServletRequest request){
        Manager manager = (Manager) request.getSession().getAttribute("manager");
        reader.setOperator(manager.getName());
        reader.setCreateDate(new Date());
        ResultInfo resultInfo;
        try {
            if (readerService.ReaderAdd(reader)){
                resultInfo=new ResultInfo(true,null,"添加成功！");
            }else {
                resultInfo=new ResultInfo(false,null,"添加失败！");
            }
        } catch (NameException e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,e.getMessage());
        }catch (Exception e){
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }
    /**删除*/
    @RequestMapping("del/{id}")
    @ResponseBody
    public ResultInfo readerDel(@PathVariable("id") Integer id){
        ResultInfo resultInfo;
        try {
            if(readerService.ReaderDel(id)){
                resultInfo=new ResultInfo(true,null,"删除成功！");
            }else {
                resultInfo=new ResultInfo(false,null,"删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常！");
        }

        return resultInfo;
    }
    /**异步请求读者信息
     * 参数：条形码
     * */
    @RequestMapping("bercode/{bercode}")
    @ResponseBody
    public ResultInfo getReaderBercode(@PathVariable("bercode") String bercode){
        ResultInfo resultInfo;
        Reader reader=readerService.getReaderCode(bercode);

        try {
            if (reader != null){
                resultInfo = new ResultInfo(true,reader,null);
            }else{
                resultInfo =new ResultInfo(false,null,"读者不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo =new ResultInfo(false,null,"服务器异常！");
        }
        return resultInfo;
    }


}
