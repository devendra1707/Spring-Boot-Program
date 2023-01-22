package com.sprinboot.ehcache.cache.loader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sprinboot.ehcache.cache.model.Users;
import com.sprinboot.ehcache.cache.repository.UsersRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    public void load() {
        List<Users> usersList = getList();
        usersRepository.saveAll(usersList);
    }

    public List<Users> getList() {
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("Ajay", "Tech",123L));
        usersList.add(new Users("Jagan", "Tech",13L));
        return usersList;
    }
}
