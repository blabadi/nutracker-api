package com.bashar.nutracker.core.repo.api;

import com.bashar.nutracker.core.dm.User;

/**
 * Created by Bashar on 2017-11-05.
 */
public interface UserRepoApi {
    User findByName(String name);

    User create(User u);
}
