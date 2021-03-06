package com.sh.carexx.mapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(scanBasePackages = { "com.sh.carexx.*" })
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.sh.carexx.*" })
@EnableHystrixDashboard
@EnableCircuitBreaker
public class MappBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(MappBootstrap.class, args);
	}
}
