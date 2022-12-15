package com.nareshit.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


public class HelloWorldApp {

	public static void main(String[] args) {

		SpringApplication.run(HelloWorldApp.class, args);

		//<bean id="obj" class="com.naresh.it.helloworld.HelloWorldImpl" scope="singleton"></bean>
	//	HelloWorldImpl obj=new HelloWorldImpl();
	//	obj.getHelloWorld();
	}

}
