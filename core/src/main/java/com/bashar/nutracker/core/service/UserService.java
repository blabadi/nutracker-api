package com.bashar.nutracker.core.service;

import com.bashar.nutracker.core.dm.User;
import com.bashar.nutracker.core.repo.api.UserRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
