package com.zcc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microcloud_eurekaServer_application {
	public static void main(String[] args) {
		SpringApplication.run(Microcloud_eurekaServer_application.class, args);
	}
}