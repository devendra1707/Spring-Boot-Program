package com.springboot.jwt.service;

import java.util.List;

import com.springboot.jwt.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
