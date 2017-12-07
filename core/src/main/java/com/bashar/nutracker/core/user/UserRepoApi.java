package com.bashar.nutracker.core.user;

/**
 * Created by Bashar on 2017-11-05.
 */
public interface UserRepoApi {

    User findByName(String name);

    User getFullUserInfo(String name);

    User create(User u);

    boolean updateProfile(String username, Profile profile);

}
