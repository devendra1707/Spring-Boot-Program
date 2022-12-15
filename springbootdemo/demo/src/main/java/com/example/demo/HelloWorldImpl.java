package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //HelloWorldImpl obj=ioc.getHelloWorldImpl();
public class HelloWorldImpl {

	@RequestMapping(value="/") //http://localhost:8080 ==> ioc.getHelloWorld();
	public String getHelloWorld() {
		return "Welcome to HelloWorld Using Spring Initializer Approach";
	}

}
