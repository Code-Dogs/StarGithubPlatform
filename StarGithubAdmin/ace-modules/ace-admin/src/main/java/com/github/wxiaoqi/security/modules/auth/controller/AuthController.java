package com.github.wxiaoqi.security.modules.auth.controller;

import com.github.wxiaoqi.security.common.exception.auth.UserInvalidException;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.modules.auth.bean.LoginResponseData;
import com.github.wxiaoqi.security.modules.auth.service.AuthService;
import com.github.wxiaoqi.security.modules.auth.util.user.JwtAuthenticationRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.github.wxiaoqi.security.common.constant.RedisKeyConstant.REDIS_KEY_CAPTCHA;

@RestController
@RequestMapping("jwt")
@Slf4j
public class AuthController {

    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ObjectRestResponse<String> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {

        log.info(authenticationRequest.getUsername() + " require logging...");
        // 获取session中的验证码
        String sessionCode = stringRedisTemplate.opsForValue().get(String.format(REDIS_KEY_CAPTCHA, authenticationRequest.getUuid()));
        if(sessionCode == null){
            throw new UserInvalidException("验证码已过期");
        }
        // 判断验证码
        if (authenticationRequest.getVerCode() == null || !sessionCode.equals(authenticationRequest.getVerCode().trim().toLowerCase())) {
            throw new UserInvalidException("验证码不正确");
        }
        Map result = authService.login(authenticationRequest);

        return new ObjectRestResponse<>().data(result);
    }

    @ApiOperation(tags = "微信相关接口",value = "微信后台登录", notes = "微信后台登录")
//    @ApiOperation(tags = "微信相关接口",value = "微信后台登录", notes = "微信后台登录", httpMethod = "POST")
    @ApiImplicitParam(name = "code",value = "通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。更多使用方法详见 小程序登录")

    @RequestMapping(value = "loginByCode", method = RequestMethod.POST)
    public ObjectRestResponse<LoginResponseData> createAuthenticationTokenByCode(@RequestBody String code) throws Exception {

        log.info(code + " require logging...");

        LoginResponseData result = authService.loginByCode(code);

        return new ObjectRestResponse<>().data(result);
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ObjectRestResponse<String> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        return new ObjectRestResponse<>().data(refreshedToken);
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ObjectRestResponse<?> verify(String token) throws Exception {
        authService.validate(token);
        return new ObjectRestResponse<>();
    }

    @RequestMapping(value = "logout", method = RequestMethod.DELETE)
    public ObjectRestResponse<?> logout(String token) throws Exception {
        authService.logout(token);
        return new ObjectRestResponse<>();
    }

}
