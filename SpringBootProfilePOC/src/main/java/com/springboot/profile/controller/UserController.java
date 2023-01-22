package com.springboot.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.profile.model.User;
import com.springboot.profile.service.CommonService;
import com.springboot.profile.service.UserService;

@RestController
public class UserController {

	
	
	@Autowired(required = true)
	private CommonService commonService;

	@GetMapping("/findAllUsers")
	public List<User> findAllUsers() {

		List<User> personList = commonService.getUserService().getUsers();
		for (User person : personList) {
			System.out.println("Person Object" + person.toString());

		}
		return personList;

	}
}
