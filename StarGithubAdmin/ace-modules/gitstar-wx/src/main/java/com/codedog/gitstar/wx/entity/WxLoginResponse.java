package com.codedog.gitstar.wx.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * wx登录返回结果包
 * 参考文档： https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
 * */
@ApiModel(value = "data", description = "微信返回结果")
public class WxLoginResponse {



    /**
     * openid 用户唯一标识
     * */
    @ApiModelProperty(value = "用户唯一标识", name = "openid", required = true)
    @JSONField(name = "openid")
    String openId;

    /**
     * 会话密钥
     * */
    @ApiModelProperty(value = "会话密钥", name = "sessionKey", required = true)
    @JSONField(name = "session_key")
    private String sessionKey;

    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
     * */
    @JSONField(name = "unionid")
    @ApiModelProperty(value = "用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明", name = "unionId", required = true)
    private String unionId;

    /**
     * 错误码
     * */
    @ApiModelProperty(value = "错误码", name = "errcode", required = true)
    @JSONField(name = "errcode")
    private Integer errCode;

    /**
     * 错误信息
     * */
    @ApiModelProperty(value = "错误信息", name = "errmsg", required = true)
    @JSONField(name = "errmsg")
    private String errMsg;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "WxLoginResponse{" +
                "openId='" + openId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", unionId='" + unionId + '\'' +
                ", errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }

    /**
     * 返回值code 枚举类
     * */
    public enum ErrCodeEnum{

        SYSTEM_BUSY(-1,"系统繁忙，此时请开发者稍候再试")
        ,SUCCESS(0,"请求成功")
        ,INVALID_CODE(40029,"无效")
        ,FREQUNCY_LIMIT(45011,"频率限制，每个用户每分钟100次");

        ErrCodeEnum(Integer code,String desc){

        }

        private Integer code;

        private String desc;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
