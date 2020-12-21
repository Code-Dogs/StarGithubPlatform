package com.codedog.gitstar.wx.service;

import com.codedog.gitstar.wx.biz.UserBiz;
import com.codedog.gitstar.wx.entity.WxUser;
import com.github.wxiaoqi.security.modules.admin.entity.User;
import com.github.wxiaoqi.security.modules.admin.util.Sha256PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private Sha256PasswordEncoder sha256PasswordEncoder;

    @Autowired
    private UserBiz userBiz;

    public User createDefaultUser(WxUser wxUser){
        User user=new User();
        user.setUsername("wx_user_"+ sha256PasswordEncoder.encode(wxUser.getOpenId()));
        user.setName("wx_user_"+ sha256PasswordEncoder.encode(wxUser.getOpenId()));
        user=userBiz.insert(user);
        wxUser.setBaseUserId(user.getId());
        return user;
    }

    public User getUserById(Integer id){
        return userBiz.getUserById(id);
    }
}
