package com.github.wxiaoqi.security.common.msg;

import com.github.wxiaoqi.security.common.enums.BizCodeEnum;

/**
 * 工厂方法
 * */
public class ObjectRestResponseFactory {

    public static <T > ObjectRestResponse<T> buildFail(String msg){
        return buildFail(msg,null);
    }

    public static <T> ObjectRestResponse<T> buildFail(String msg,T data){
        ObjectRestResponse<T> response=new ObjectRestResponse<>();
        response.setMessage(msg);
        response.setStatusCode(BizCodeEnum.FAIL.getCode());
        response.setData(data);
        return response;
    }
}
