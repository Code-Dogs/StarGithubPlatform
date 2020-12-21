package com.codedog.gitstar.wx.biz;

import com.github.wxiaoqi.security.modules.admin.entity.User;
import com.codedog.gitstar.wx.entity.WxUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(value = "ace-admin")
@RequestMapping(value = "/api")
public interface UserBiz {
    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    @ResponseBody
    User insert(@RequestBody User user);

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    User getUserById(@PathVariable(value = "id") Integer id);
}
