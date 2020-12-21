package com.codedog.gitstar.wx.service;

import com.github.wxiaoqi.security.api.vo.user.UserInfo;
import com.github.wxiaoqi.security.modules.auth.bean.LoginResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(value = "ace-admin")
public interface AuthService {

    @PostMapping(value = "/jwt/generateToken")
    @ResponseBody
    LoginResponseData generateToken(@RequestBody UserInfo userInfo) throws Exception;
}
