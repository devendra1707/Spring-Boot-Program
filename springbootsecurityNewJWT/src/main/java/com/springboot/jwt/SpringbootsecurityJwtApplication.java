package com.springboot.jwt;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.springboot.jwt.model.User;
import com.springboot.jwt.service.UserService;

@SpringBootApplication
public class SpringbootsecurityJwtApplication implements CommandLineRunner{

	@Autowired
	private UserService service;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootsecurityJwtApplication.class, args);
	}
	
	@Bean
	public org.springframework.web.filter.CorsFilter corsFilter() {
		//final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		final org.springframework.web.cors.UrlBasedCorsConfigurationSource source=new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
		final CorsConfiguration config=new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedOrigin("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		
		source.registerCorsConfiguration("/**", config);
		return new org.springframework.web.filter.CorsFilter(source);
	}

	@Override
	public void run(String... args) throws Exception {
		User userObj=new User("guest","guest","guest@gmail.com","guest",true,"GUEST","11111");
		service.save(userObj);
		
		
	}

}
