package com.bashar.nutracker.core.repo.mongo;

import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bashar on 2017-09-03.
 */
@Repository
public class FoodDao implements FoodRepoApi {
    @Autowired
    MongoOperations operations;

    @Override
    public Food create(Food f) {
         operations.save(f);
         return f;
    }

    @Override
    public List<Food> getAll() {
        return operations.findAll(Food.class);
    }


}
