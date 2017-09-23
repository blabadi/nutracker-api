package com.bashar.nutracker.rest.api;

import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.service.FoodSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
@RestController()
@RequestMapping("food")
public class FoodApi {

    @Autowired
    FoodSvc foodSvc;

    @RequestMapping("/all")
    public List<Food> getAll(){
        return foodSvc.getAll();
    }

}
