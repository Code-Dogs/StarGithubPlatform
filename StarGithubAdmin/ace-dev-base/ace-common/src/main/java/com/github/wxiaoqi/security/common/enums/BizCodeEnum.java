package com.github.wxiaoqi.security.common.enums;

/**
 * 业务code枚举
 * */
public enum BizCodeEnum {

    SUCCESS(200,"成功")

    ,FAIL(-100,"失败")
    ;

    private Integer code;

    private String msg;

    BizCodeEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
