package com.springboot.jwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jwt.domain.Response;
import com.springboot.jwt.model.User;
import com.springboot.jwt.service.UserService;

@RestController
public class PreLoginController {

	@Autowired
	private UserService userService;
	
		@PostMapping(value="/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User dbUser=null;
		try {
			dbUser=userService.save(user);
		}catch(Exception ex) {
			return new ResponseEntity<Response>(new Response("User is Saved Sudcessfully"),HttpStatus.OK); 
		}
		if(dbUser!=null) {
			return new ResponseEntity<Response>(new Response("User is Saved Sudcessfully"),HttpStatus.OK); 
		}
		
		return null;
	}
}
