package com.bashar.nutracker.core.repo.api;

import com.bashar.nutracker.core.dm.Food;

import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
public interface FoodRepoApi {
    Food create(Food f);
    List<Food> getAll();
}
