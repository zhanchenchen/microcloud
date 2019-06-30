package com.zcc.common.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    public Logger.Level getFeignLoggerLevel() { //开启feign日志输出
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthenticationInterceptor() {  //feign认证配置  BasicAuthRequestInterceptor巨坑！！
        return new BasicAuthRequestInterceptor("zcc", "zcc");
    }
}
