package com.codedog.gitstar.wx.mapper;

import com.codedog.gitstar.wx.entity.WxUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface WxUserMapper extends Mapper<WxUser> {
    public WxUser selectWxUserByOpenId(@Param("openId") String openId);
}