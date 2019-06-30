package com.zcc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker //启动熔断机制
public class MicrocloudProviderHystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicrocloudProviderHystrixApplication.class, args);
	}
}
