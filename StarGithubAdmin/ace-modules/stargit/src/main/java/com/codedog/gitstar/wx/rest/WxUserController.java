package com.codedog.gitstar.wx.rest;

import com.codedog.gitstar.wx.biz.SampleDataTestBiz;
import com.codedog.gitstar.wx.entity.SampleDataTest;
import com.github.wxiaoqi.security.common.context.BaseContextHandler;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wxUser")
public class WxUserController extends BaseController<SampleDataTestBiz, SampleDataTest> {
    /**
     * 获取当前登录的用户信息
     * */
    @GetMapping("/info")
    public ObjectRestResponse<String> info(){
        return new ObjectRestResponse<>().data(BaseContextHandler.getName());
    }
}