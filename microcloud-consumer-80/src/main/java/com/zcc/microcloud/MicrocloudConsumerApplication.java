package com.zcc.microcloud;

import com.zcc.commons.config.MyLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "ribbonClient",configuration = MyLoadBalanceConfig.class) //自定义负载均衡策略
public class MicrocloudConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicrocloudConsumerApplication.class, args);
	}
}
