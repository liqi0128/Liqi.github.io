package com.book.service;

import com.book.pojo.Parameter;

public interface ParameterService {
    /**获取参数*/
    public Parameter getParameters();
    /**修改参数*/
    public boolean modifyParameter(Parameter parameter);
}
