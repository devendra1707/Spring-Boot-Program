package com.springboot.jwt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jwt.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {

	User findByEmailIgnoreCase(String username);

	
	
	
}
