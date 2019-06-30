package com.zcc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.zcc.service","com.zcc.microcloud","com.zcc.common.config"})
@EnableFeignClients(basePackages = {"com.zcc.service"}) //如果客户端在主类包下可以不指定包名
public class MicrocloudConsumerHystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicrocloudConsumerHystrixApplication.class, args);
	}
}
