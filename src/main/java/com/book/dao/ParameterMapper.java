package com.book.dao;

import com.book.pojo.Parameter;

/**参数设置*/
public interface ParameterMapper {
    /**获取参数*/
    public Parameter getParameters();
    /**修改参数*/
    public int parameterModify(Parameter parameter);
}
