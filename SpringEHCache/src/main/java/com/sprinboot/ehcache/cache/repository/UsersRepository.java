package com.sprinboot.ehcache.cache.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinboot.ehcache.cache.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
}
