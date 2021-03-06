package com.codedog.gitstar.wx.rest;

import com.codedog.gitstar.wx.service.LoginService;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.modules.auth.bean.LoginResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("jwt")
@Slf4j
public class AuthController {

//    @Value("${jwt.token-header}")
//    private String tokenHeader;

    @Autowired
    private LoginService loginService;

    @ApiOperation(tags = "微信相关接口",value = "微信后台登录", notes = "微信后台登录")
//    @ApiOperation(tags = "微信相关接口",value = "微信后台登录", notes = "微信后台登录", httpMethod = "POST")
    @ApiImplicitParam(name = "code",value = "通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。更多使用方法详见 小程序登录")

    @RequestMapping(value = "loginByCode", method = RequestMethod.POST)
    public ObjectRestResponse<LoginResponseData> createAuthenticationTokenByCode(@RequestBody String code) throws Exception {

        log.info(code + " require logging...");

        LoginResponseData result = loginService.login(code);

        return new ObjectRestResponse<>().data(result);
    }


}
