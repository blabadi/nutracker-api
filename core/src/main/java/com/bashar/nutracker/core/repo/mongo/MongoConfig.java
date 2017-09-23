package com.bashar.nutracker.core.repo.mongo;

import com.bashar.nutracker.core.repo.hibernate.dao.*;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Bashar on 2017-09-02.
 */

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = {FoodDao.class})
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getProperty("mongo.db.name");
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1");
    }
}
