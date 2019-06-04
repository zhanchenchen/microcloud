package com.zcc.commons.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
//自定義ribbon配置类需要放在非主类的包下
public class MyLoadBalanceConfig {
    @Bean
    public IRule ribbonRule(){ //IRule是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule();  //随机访问策略
    }
}
