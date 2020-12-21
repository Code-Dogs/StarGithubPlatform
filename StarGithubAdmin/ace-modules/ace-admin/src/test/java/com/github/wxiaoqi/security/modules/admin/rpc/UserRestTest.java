package com.github.wxiaoqi.security.modules.admin.rpc;

import com.github.wxiaoqi.security.modules.admin.biz.UserBiz;
import com.github.wxiaoqi.security.modules.admin.entity.User;
import com.github.wxiaoqi.security.modules.auth.controller.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserRestTest extends BaseControllerTest {

    @Autowired
    private UserBiz userBiz;

    @Test
    void insert() {
        User user=new User();
        user.setName("testaaa");
        userBiz.insert(user);
        System.out.println("aaaaa");
        System.out.println(user.getId());
        System.out.println("ddddd");
    }
}