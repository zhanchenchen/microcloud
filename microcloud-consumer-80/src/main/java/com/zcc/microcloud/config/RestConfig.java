package com.zcc.microcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class RestConfig {
    @Bean
    public HttpHeaders getHttpHeaders(){    //http头信息配置
        HttpHeaders headers=new HttpHeaders();  //定义一个Http头信息
        String auth="zcc:zcc"  ;    //认证原始信息
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));  //加密处理
        //在授权头信息内容配置的时候加密信息一定要与“Basic”之间有一个空格
        String authHeader="Basic "+new String(encodeAuth);
        headers.set("Authorization",authHeader);
        return headers;
    }
    @Bean
    @LoadBalanced   //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
