package com.zcc.microcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * zuul过滤处理
 */
//@Component
public class AuthorizedRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //进行zuul过滤的时候可以设置其过滤执行的位置
        //1、pre：在请求处理之前执行过滤，如果要访问一定是在请求前设置头信息
        //2、route：在进行路由请求的时候被调用
        //3、post：在路由之后发送请求信息的时候被调用
        //4、error：再出现错误之后调用
        //5、static：未知
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;//设置优先级，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() { //filter是否执行，true执行run方法
        return false;
    }

    @Override
    public Object run() throws ZuulException {  //表示具体的过滤执行操作
        RequestContext ctx=RequestContext.getCurrentContext();//获得请求上下文
        String auth="zcc:zcc";
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));//进行us-ascii编码,并且加密处理
        String authHeader="Basic "+new String(encodeAuth);//设置验证信息
        ctx.addZuulRequestHeader("Authorization",auth);
        System.err.println(ctx.getZuulRequestHeaders());
        return null;
    }
}
