package com.book.service.Impl;

import com.book.dao.ParameterMapper;
import com.book.pojo.Parameter;
import com.book.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public Parameter getParameters() {
        return parameterMapper.getParameters();
    }

    @Override
    public boolean modifyParameter(Parameter parameter) {
        int i = parameterMapper.parameterModify(parameter);
        if (i==1){
            return true;
        }
        return false;
    }
}
