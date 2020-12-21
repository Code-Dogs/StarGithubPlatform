package com.codedog.gitstar.wx.biz;

import com.codedog.gitstar.wx.mapper.WxUserMapper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.codedog.gitstar.wx.entity.WxUser;
import com.github.wxiaoqi.security.modules.admin.util.Sha256PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${DESCRIPTION}
 *
 * @author the sun
 * @create 2017-06-08 16:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxUserBiz extends BaseBiz<WxUserMapper, WxUser> {

    private Sha256PasswordEncoder encoder = new Sha256PasswordEncoder();

    /**
     * 根据用户名获取用户信息
     * @param openId
     * @return
     */
    public WxUser getUserByOpenId(String openId){
        WxUser user = new WxUser();
        user.setOpenId(openId);
        return mapper.selectOne(user);
    }


}
