package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.service.FoodSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
@RestController
@RequestMapping("/api/food")
public class FoodApi {

    @Autowired
    FoodSvc foodSvc;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Food> getAll(){
        return foodSvc.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Food create(@RequestBody Food food){
        System.out.println(food);
        return foodSvc.createFood(food);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Food> search(@RequestParam("name") String name){
        return foodSvc.searchFoodByName(name);
    }


}
