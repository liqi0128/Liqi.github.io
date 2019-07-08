package com.book.controller;

import com.book.pojo.Parameter;
import com.book.pojo.ResultInfo;
import com.book.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("parameter")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    @RequestMapping("info")
    public String Parameters(HttpServletRequest request){
        Parameter parameter =parameterService.getParameters();
        request.getSession().setAttribute("parameter",parameter);
        return "redirect:/parameter_modify.jsp";
    }
    @RequestMapping("modify")
    @ResponseBody
    public ResultInfo ParameterModify(Parameter parameter){
        ResultInfo resultInfo;
        boolean flg=parameterService.modifyParameter(parameter);
        if(flg){
            resultInfo=new ResultInfo(true,null,"修改成功！");
        }else {
            resultInfo=new ResultInfo(false,null,"修改失败！");
        }
    return resultInfo;
    }

}
