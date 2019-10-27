package com.nvd.exception;

import com.nvd.enums.JXCEnum;
import lombok.Getter;

@Getter
public class JXCException extends RuntimeException {

    private Integer code;

    private String msg;

    public JXCException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public JXCException(JXCEnum jxcEnum){
        super(jxcEnum.getMsg());
        this.code=jxcEnum.getCode();
    }
}
