package com.github.wxiaoqi.security.modules.auth.bean;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录结果返回包
 * 参考文档： https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
 * */
@ApiModel(value = "data", description = "登录返回结果")
public class LoginResponseData {



    /**
     * openid 用户唯一标识
     * */
    @ApiModelProperty(value = "登录成功用户凭证token", name = "token", required = true)
    @JSONField(name = "token")
    String token;

    /**
     * 会话密钥
     * */
    @ApiModelProperty(value = "用户id主键", name = "id", required = true)
    @JSONField(name = "id")
    private String id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
