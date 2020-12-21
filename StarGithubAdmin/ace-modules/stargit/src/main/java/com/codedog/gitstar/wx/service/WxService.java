package com.codedog.gitstar.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.codedog.gitstar.wx.config.WxConfiguration;
import com.codedog.gitstar.wx.entity.WxLoginResponse;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponseFactory;
import com.github.wxiaoqi.security.common.util.http.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;

@Service("exService")
public class WxService {

    private String jscode2session_url_template="https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";

    @Resource
    private WxConfiguration wxConfiguration;

    /**
     * 根据前端调用wx.login 返回的code，调用微信服务，获取返回值
     * 具体参见：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
     * */
    public WxLoginResponse loginToWxByCode(String code){
        String requestUrl= MessageFormat.format(jscode2session_url_template,wxConfiguration.getAppId(),wxConfiguration.getSecret(),code);
        String res=HttpUtils.sendGet(requestUrl,"");
        WxLoginResponse wxLoginResponse=JSONObject.parseObject(res, WxLoginResponse.class);
        //微信实际返回和接口文档有区别，只会返回openid和sessionkey，当为空时，直接设置成功
        if(wxLoginResponse!=null&& wxLoginResponse.getErrCode()==null && StringUtils.isNotEmpty(wxLoginResponse.getOpenId())&&StringUtils.isNotEmpty(wxLoginResponse.getSessionKey())){
            wxLoginResponse.setErrCode(WxLoginResponse.ErrCodeEnum.SUCCESS.getCode());
        }
//        WxLoginResponse wxLoginResponse=new WxLoginResponse();
//        wxLoginResponse.setErrCode(WxLoginResponse.ErrCodeEnum.SUCCESS.getCode());
//        wxLoginResponse.setOpenId("testopenid");
//        wxLoginResponse.setUnionId("testunionid");
//        wxLoginResponse.setSessionKey("testsessionkey");
        return wxLoginResponse;
    }

    /**
     * 根据code登录系统
     * */
    public ObjectRestResponse<String> loginByCode(String code){
        WxLoginResponse wxLoginResponse=loginToWxByCode(code);
        //微信code登录失败，直接返回
        if(!wxLoginResponse.getErrCode().equals(WxLoginResponse.ErrCodeEnum.SUCCESS.getCode())){
            return ObjectRestResponseFactory.buildFail("微信登录失败",wxLoginResponse.toString());
        }
        //登录成功，登录当前系统
        //未绑定，直接注册账号绑定
        return null;
    }

}
