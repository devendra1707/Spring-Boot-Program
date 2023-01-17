package com.springboot.EurekaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaServer
// @EnableEurekaServer -> It will launch the Eureka Registration Service
//		EnableEurekaServer -> It will launch the Eurkea Discovery Service
//@EnableZuulProxy -> This will verify the URl based on ZUUL configuration.
@SpringBootApplication
public class EurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}

}
