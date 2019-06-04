package com.zcc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zcc.service"}) //如果客户端在主类包下可以不指定包名
public class MicrocloudConsumerFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicrocloudConsumerFeignApplication.class, args);
	}
}
