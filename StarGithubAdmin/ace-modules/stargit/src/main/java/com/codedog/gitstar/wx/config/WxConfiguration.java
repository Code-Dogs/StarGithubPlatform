package com.codedog.gitstar.wx.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class WxConfiguration {

    @Value("${wx.appid}")
    private String appId;

    @Value("${wx.secret}")
    private String secret;
}
