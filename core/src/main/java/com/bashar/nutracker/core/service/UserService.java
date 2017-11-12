package com.bashar.nutracker.core.service;

import com.bashar.nutracker.core.dm.User;
import com.bashar.nutracker.core.repo.api.UserRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bashar on 2017-11-05.
 */
@Service
public class UserService {

    @Autowired
    UserRepoApi userRepo;

    public User getByName(String name) {
        User u = userRepo.findByName(name);
        return u;
    }

    public User createUser(User user) {
        //check existing
        User existing = userRepo.findByName(user.getName());
        if (existing != null) {
            throw new IllegalArgumentException("user name is used");
        }

        //add user role
        Set<String> roles = new HashSet<>();
        roles.add("USER");

        // set attributes
        user
            .active(true)
            .createdAt(new Date())
            .roles(roles)
            .password(new BCryptPasswordEncoder().encode(user.getPassword()));

        //save
        User created = userRepo.create(user);
        return created;
    }
}
