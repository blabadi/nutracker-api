package com.bashar.nutracker.core.repo.jpa;

import com.bashar.nutracker.core.dm.Food;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bashar on 2017-08-27.
 */
public interface FoodRepo extends CrudRepository<Food, Long> {
}
