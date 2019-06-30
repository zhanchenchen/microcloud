package com.zcc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //Hystrix监控
public class MicrocloudConsumerHystrixDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicrocloudConsumerHystrixDashboardApplication.class, args);
	}
}
