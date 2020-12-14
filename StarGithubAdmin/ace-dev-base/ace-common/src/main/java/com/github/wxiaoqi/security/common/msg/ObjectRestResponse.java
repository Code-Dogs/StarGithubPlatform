package com.github.wxiaoqi.security.common.msg;

import com.github.wxiaoqi.security.common.enums.BizCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Ace on 2017/6/11.
 */
@ApiModel(value = "objectRestResponse", description = "rest对象返回结果")
public class ObjectRestResponse<T> extends BaseResponse {
    @ApiModelProperty(value = "返回结果", name = "data", required = true)
    T data;
    
    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }
    public T getData() {
        return data;
    }

    public ObjectRestResponse setData(T data) {
        this.data = data;
        return this;
    }




}
