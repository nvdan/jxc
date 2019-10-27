package com.nvd.vo;

import lombok.Data;

@Data
public class ResultVO {

    private Integer code;

    private String msg;

    private Object data;

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
