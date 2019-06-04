package com.zcc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//启动SpringBoot程序，自动扫描子包
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@MapperScan(value = {"com.zcc.microcloud.dao"})
public class MicrocloudProvider8001Application {
	public static void main(String[] args) {
		SpringApplication.run(MicrocloudProvider8001Application.class, args);
	}
}
//@SpringBootApplication//启动SpringBoot程序，自动扫描子包
//public class StartSpringBootMain extends SpringBootServletInitializer{
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(StartSpringBootMain.class);
//	}
//	public static void main(String[] args) {
//		SpringApplication.run(StartSpringBootMain.class, args);
//	}
//}
