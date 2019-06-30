package com.zcc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine //Hystrix监控聚合
public class MicrocloudProviderTrubineApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicrocloudProviderTrubineApplication.class, args);
	}
}
