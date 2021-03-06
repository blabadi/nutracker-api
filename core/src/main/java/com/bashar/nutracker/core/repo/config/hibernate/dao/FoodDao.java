package com.bashar.nutracker.core.repo.config.hibernate.dao;

import com.bashar.nutracker.core.food.Food;
import com.bashar.nutracker.core.food.FoodRepoApi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
@Repository
public class FoodDao implements FoodRepoApi {

    @Autowired
    SessionFactory factory;

    @Override
    public Food create(Food f) {
        Session s = factory.getCurrentSession();
        return (Food) s.get(Food.class, s.save(f));
    }

    @Override
    public List<Food> getAll() {
        Session s = factory.getCurrentSession();
        return (List<Food>) s.createQuery("from Food").list();
    }

    @Override
    public List<Food> searchFoodByName(String name) {
        return null;
    }
}
