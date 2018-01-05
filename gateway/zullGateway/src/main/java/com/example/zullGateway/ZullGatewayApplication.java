package com.example.zullGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableAutoConfiguration
//@EnableHystrix
public class ZullGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullGatewayApplication.class, args);
	}
}
