package com.bashar.nutracker.core.repo.jpa;

import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bashar on 2017-08-27.
 */
@Repository
public class JPAFoodRepo implements FoodRepoApi {
    @Autowired
    FoodRepo foodRepo;


    @Override
    public Food create(Food f) {
        return foodRepo.save(f);
    }

    @Override
    public List<Food> getAll() {
        Iterable<Food> result = foodRepo.findAll();
        final List<Food> foods = new ArrayList<>();
        if (result != null){
            result.forEach(new Consumer<Food>() {
                @Override
                public void accept(Food food) {
                    foods.add(food);
                }
            });
        }

        return foods;
    }

    @Override
    public List<Food> searchFoodByName(String name) {
        return null;
    }
}
