package com.nvd.result;

import com.nvd.enums.JXCEnum;
import com.nvd.exception.JXCException;
import com.nvd.vo.ResultVO;

public class R {

    public static ResultVO ok(Object data){
        return new ResultVO(0,"", data);
    }

    public static ResultVO ok(){
        return ok(null);
    }

    public static ResultVO error(JXCEnum jxcEnum){
        return new ResultVO(jxcEnum.getCode(),jxcEnum.getMsg(),null);
    }

    public static ResultVO error(JXCException je){
        return new ResultVO(je.getCode(),je.getMsg(),null);
    }

    public static ResultVO error(Integer code,String msg){
        return new ResultVO(code,msg,null);
    }
}
