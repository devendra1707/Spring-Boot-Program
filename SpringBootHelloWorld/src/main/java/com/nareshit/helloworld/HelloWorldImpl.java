package com.nareshit.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldImpl {


	@RequestMapping(value="/")
	public String getHelloWorld() {
		return "Welcom to 7 to 8 AM Spring Boot New Batch";
	}
}
