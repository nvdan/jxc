package com.nvd.enums;

import lombok.Getter;

@Getter
public enum JXCEnum {
    USER_LOGOUT_ERROR(5,"退出登录失败！"),
    USER_NOT_LOGIN(4,"未登录"),
    PARAM_ERROR(3,"参数不合法！"),
    PRODUCT_UPDATE_ERROR(2,"修改商品信息失败！"),
    SALE_ADD_ERROR(1,"添加销售记录失败！")
    ;

    private Integer code;

    private String msg;

    JXCEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
