package com.springboot.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.profile.model.User;
import com.springboot.profile.service.UserService;

@SpringBootApplication
public class SpringBootProfilePocApplication 
implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Value(value="${spring.profiles.active}")
	private String profile;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilePocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		User user=new User();
		if(profile==null) {
			profile="local";
		}
		user.setName("Test User Created with the profile name as ..." +profile);
		user.setId(1);
		userService.saveUser(user);
		
	}

}
