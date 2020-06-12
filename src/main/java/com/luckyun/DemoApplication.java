package com.luckyun;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
public class DemoApplication extends MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}