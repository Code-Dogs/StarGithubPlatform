package com.codedog.gitstar.wx;

import com.github.wxiaoqi.security.modules.admin.entity.User;

public class Test {
    public static void main(String[] args){
        Test test=new Test();
        test.test();
    }

    public void test(){
        User user=new User();
        user=test2(user);
        System.out.println(user.getId());
    }
    public User test2(User user){
        user.setId(22);
        return user;
    }
}
