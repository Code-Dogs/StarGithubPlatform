package com.codedog.gitstar.wx.service;

import com.codedog.gitstar.wx.biz.UserBiz;
import com.codedog.gitstar.wx.biz.WxUserBiz;
import com.codedog.gitstar.wx.entity.WxLoginResponse;
import com.github.wxiaoqi.security.api.vo.user.UserInfo;
import com.github.wxiaoqi.security.common.exception.auth.UserInvalidException;
import com.github.wxiaoqi.security.modules.admin.entity.User;
import com.codedog.gitstar.wx.entity.WxUser;
import com.github.wxiaoqi.security.modules.auth.bean.LoginResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {


    @Autowired
    private WxService wxService;


    @Autowired
    private WxUserBiz wxUserBiz;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    public LoginResponseData login(String code) throws Exception{
        UserInfo info = validateByCode(code);
        if (!StringUtils.isEmpty(info.getId())) {
            LoginResponseData loginResponseData=authService.generateToken(info);
            return loginResponseData;
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    public UserInfo validateByCode(String code) {
        WxLoginResponse wxLoginResponse=wxService.loginToWxByCode(code);
        //微信code登录失败，直接返回
        if(!wxLoginResponse.getErrCode().equals(WxLoginResponse.ErrCodeEnum.SUCCESS.getCode())){
            throw new UserInvalidException(wxLoginResponse.getErrMsg());
        }
        //登录成功，登录当前系统
        //如果不存在用户，直接注册
        WxUser wxUser = wxUserBiz.getUserByOpenId(wxLoginResponse.getOpenId());
        User user=null;
        if(wxUser==null){
            wxUser=new WxUser();
            BeanUtils.copyProperties(wxLoginResponse,wxUser);
            //创建基础用户
            user=userService.createDefaultUser(wxUser);
            //创建微信用户
            wxUser.setBaseUserId(user.getId());
            wxUserBiz.insert(wxUser);
        }else{
            user=userService.getUserById(wxUser.getBaseUserId());
        }
        UserInfo info=new UserInfo();
        if(user!=null){
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId().toString());
        }
        return info;
    }
}
