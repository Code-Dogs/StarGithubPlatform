package com.codedog.gitstar.wx.rest;

import com.codedog.gitstar.wx.biz.SampleDataTestBiz;
import com.codedog.gitstar.wx.entity.SampleDataTest;
import com.codedog.gitstar.wx.entity.WxLoginResponse;
import com.codedog.gitstar.wx.service.WxService;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("wx")
public class WxController extends BaseController<SampleDataTestBiz, SampleDataTest> {

    @Resource
    private WxService wxService;

//    @ApiOperation(tags = "微信相关接口",value = "微信后台登录", notes = "微信后台登录", httpMethod = "GET")
//    @ApiImplicitParam(name = "code",value = "通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。更多使用方法详见 小程序登录")
//    @GetMapping("/login")
//    public ObjectRestResponse<WxLoginResponse> login( String code){
//        WxLoginResponse wxLoginResponse=wxService.loginByCode(code);
//        return new ObjectRestResponse<>().data(wxLoginResponse);
//    }
}