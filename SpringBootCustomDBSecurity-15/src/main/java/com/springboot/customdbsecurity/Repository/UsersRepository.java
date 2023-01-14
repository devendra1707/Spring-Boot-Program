package com.springboot.customdbsecurity.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.customdbsecurity.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}

