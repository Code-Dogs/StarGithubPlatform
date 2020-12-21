package com.github.wxiaoqi.security.modules.auth.service;


import com.github.wxiaoqi.security.api.vo.user.UserInfo;
import com.github.wxiaoqi.security.modules.auth.bean.LoginResponseData;
import com.github.wxiaoqi.security.modules.auth.util.user.JwtAuthenticationRequest;

import java.util.Map;

public interface AuthService {
    Map login(JwtAuthenticationRequest authenticationRequest) throws Exception;
//    LoginResponseData loginByCode(String code) throws Exception;

    String refresh(String oldToken) throws Exception;
    void validate(String token) throws Exception;

    void logout(String token) throws Exception;

    Map generateLoginToken(UserInfo userInfo) throws Exception;
}
