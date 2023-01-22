package com.springboot.profile.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.profile.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

}
