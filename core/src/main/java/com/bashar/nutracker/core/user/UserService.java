package com.bashar.nutracker.core.user;

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
        created.setPassword("");
        return created;
    }

    public void updateProfile(String username, Profile profile) {
        userRepo.updateProfile(username, profile);
    }

    public User getFullInfo(String username) {
        User u = this.userRepo.getFullUserInfo(username);
        u.setPassword("");
        return u;
    }
}
