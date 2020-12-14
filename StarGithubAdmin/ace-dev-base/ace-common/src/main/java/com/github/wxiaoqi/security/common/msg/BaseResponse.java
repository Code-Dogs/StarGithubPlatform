package com.github.wxiaoqi.security.common.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ace on 2017/8/23.
 */
@ApiModel(value = "baseResponse", description = "返回结果")
public class BaseResponse {
    @ApiModelProperty(value = "状态码", name = "statusCode", required = true)
    private int statusCode = 200;
    @ApiModelProperty(value = "返回消息提示", name = "message", required = true)
    private String message;

    public BaseResponse(int status, String message) {
        this.statusCode = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
