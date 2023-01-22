package com.springboot.profile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.profile.dao.UserRepository;
import com.springboot.profile.model.User;



@Service
//@Profile(value = { "local", "dev", "prod" })
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<com.springboot.profile.model.User> getUsers() {
		return repository.findAll();
	}
	
	public void saveUser(User entity)
	{
	 repository.save(entity);

	}

}
