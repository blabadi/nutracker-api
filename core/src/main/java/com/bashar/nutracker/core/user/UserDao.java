package com.bashar.nutracker.core.user;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Bashar on 2017-09-03.
 */
@Repository
public class UserDao implements UserRepoApi {
    @Autowired
    MongoOperations operations;

    @Override
    public User findByName(String name) {
        Query findQuery = new Query();
        findQuery.addCriteria(Criteria.where("name").is(name));
        findQuery.fields().exclude("profile");
        User u = operations.findOne(findQuery, User.class);
        return u;
    }

    @Override
    public User getFullUserInfo(String name) {
        Query findQuery = new Query();
        findQuery.addCriteria(Criteria.where("name").is(name));
        User u = operations.findOne(findQuery, User.class);
        return u;
    }

    @Override
    public User create(User u) {
        operations.save(u);
        return u;
    }

    @Override
    public boolean updateProfile(String username, Profile profile) {
        Query findQuery = new Query();
        findQuery.addCriteria(Criteria.where("name").is(username));
        Update update = new Update();
        update.set("profile", profile);
        WriteResult res = operations.upsert(findQuery, update, User.class);
        return res.wasAcknowledged();
    }

}
