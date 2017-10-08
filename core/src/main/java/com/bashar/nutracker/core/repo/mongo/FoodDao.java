package com.bashar.nutracker.core.repo.mongo;

import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

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

    @Override
    public List<Food> searchFoodByName(String name) {
        Query findQuery = new Query();
        findQuery.limit(10);
        String nameRegx = name;
        Pattern p = Pattern.compile(nameRegx, Pattern.CASE_INSENSITIVE);
        findQuery.addCriteria(Criteria.where("name").regex(p));
        List<Food> result = operations.find(findQuery, Food.class);
        return result;
    }


}
