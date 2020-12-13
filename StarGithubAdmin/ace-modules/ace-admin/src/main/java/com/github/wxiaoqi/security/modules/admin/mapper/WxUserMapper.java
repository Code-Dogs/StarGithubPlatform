package com.github.wxiaoqi.security.modules.admin.mapper;

import com.github.wxiaoqi.security.modules.admin.entity.User;
import com.github.wxiaoqi.security.modules.admin.entity.WxUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WxUserMapper extends Mapper<WxUser> {
    public WxUser selectWxUserByOpenId(@Param("openId") String openId);
}