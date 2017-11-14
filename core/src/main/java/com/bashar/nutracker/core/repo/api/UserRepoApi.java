package com.bashar.nutracker.core.repo.api;

import com.bashar.nutracker.core.dm.Profile;
import com.bashar.nutracker.core.dm.User;

/**
 * Created by Bashar on 2017-11-05.
 */
public interface UserRepoApi {

    User findByName(String name);

    User getFullUserInfo(String name);

    User create(User u);

    boolean updateProfile(String username, Profile profile);

}
