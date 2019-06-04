package com.zcc.common.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthenticationInterceptor(){  //feign认证配置  BasicAuthRequestInterceptor巨坑！！
        return new BasicAuthRequestInterceptor("zcc","zcc");
    }
}
