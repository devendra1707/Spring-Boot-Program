package com.sprinboot.ehcache.cache.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.sprinboot.ehcache.cache.model.Users;
import com.sprinboot.ehcache.cache.repository.UsersRepository;

@Component
public class UsersCache {

    @Autowired
    UsersRepository usersRepository;

    @Cacheable(value = "usersCache", key = "#name")
    public Users getUser(String name) {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByName(name);
        
        
        //Ramu -> Ramu, Ramu , 20, ramu@gmail.com
        
        //#name -> Ramu
        
        //usercache ->  Ramu, Ramu , 20, ramu@gmail.com
    }
}
