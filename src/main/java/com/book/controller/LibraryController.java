package com.book.controller;


import com.book.pojo.Library;
import com.book.pojo.ResultInfo;
import com.book.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;
    /**查看图书馆信息*/
    @RequestMapping("/Info")
    public String LibraryInfo(HttpServletRequest request){
        Library library=libraryService.getLibraryInformation();
        request.getSession().setAttribute("library",library);
        return "redirect:/library_modify.jsp";
    }
    /**修改图书馆信息*/
    @RequestMapping( "/Modify")
    @ResponseBody
    public ResultInfo LibraryModify(Library library){
        ResultInfo resultInfo;
            int n =libraryService.getLibraryModify(library);
            if (n==1){
                resultInfo=new ResultInfo(true,null,null);
            }else {
                resultInfo=new ResultInfo(false,null,null);
            }
      return resultInfo;
    }



}
