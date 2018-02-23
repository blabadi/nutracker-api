package com.bashar.nutracker.core.food;

import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
public interface FoodRepoApi {
    Food create(Food f);
    List<Food> getAll();
    List<Food> searchFoodByName(String name);
}
