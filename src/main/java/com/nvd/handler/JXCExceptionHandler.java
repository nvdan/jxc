package com.nvd.handler;

import com.nvd.exception.JXCException;
import com.nvd.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JXCExceptionHandler {

    @ExceptionHandler(JXCException.class)
    public ResultVO handler(JXCException je){
        return new ResultVO(je.getCode(),je.getMessage(),null);
    }
}
