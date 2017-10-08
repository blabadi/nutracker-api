package com.bashar.nutracker.core.service;

import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import com.bashar.nutracker.core.repo.jpa.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bashar on 2017-08-27.
 */
@Service
public class FoodSvc {

    @Autowired
    private FoodRepoApi foodRepo;

    public Food createFood(Food f) {
        return foodRepo.create(f);
    }

    public List<Food> getAll() {
        return foodRepo.getAll();
    }

    public FoodRepoApi getFoodRepo() {
        return foodRepo;
    }

    public void setFoodRepo(FoodRepoApi foodRepo) {
        this.foodRepo = foodRepo;
    }

    public List<Food> searchFoodByName(String name) {
        return foodRepo.searchFoodByName(name);
    }
}
