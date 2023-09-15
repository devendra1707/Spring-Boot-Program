package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping(value = "/normal")
	public ResponseEntity<String> normalUser(){
		return ResponseEntity.ok("Yes, I am normal user.");
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/admin")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok("Yes, I am admin user.");
		
	}
	@PreAuthorize("hasRole('GUEST')")
	@GetMapping(value = "/guest")
	public ResponseEntity<String> guestUser(){
		return ResponseEntity.ok("Yes, I am guest user.");
		
	}
	@GetMapping(value = "/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("Yes, I am public user.");
		
	}
}
