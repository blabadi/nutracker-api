package com.bashar.nutracker.core.food;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bashar on 2017-08-27.
 */
public interface FoodRepo extends CrudRepository<Food, Long> {
}
