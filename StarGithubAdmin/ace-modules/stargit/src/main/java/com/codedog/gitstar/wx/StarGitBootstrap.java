package com.codedog.gitstar.wx;

import com.github.wxiaoqi.security.auth.client.EnableAceAuthClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author laogandie
 * @create 2020/9/5.
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.github.wxiaoqi.security.sample.mapper","com.codedog.gitstar.wx.mapper"})
@EnableAceAuthClient
@EnableFeignClients({"com.codedog.gitstar.wx","com.github.wxiaoqi.security.auth.client.feign"})
@ComponentScan({"com.codedog.gitstar.wx","com.github.wxiaoqi.security"})
public class StarGitBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(StarGitBootstrap.class).run(args);
    }
}
