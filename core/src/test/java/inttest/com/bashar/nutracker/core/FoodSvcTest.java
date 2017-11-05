package inttest.com.bashar.nutracker.core;

import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.service.FoodSvc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;
import java.util.Map;

/**
 * Created by Bashar on 2017-09-03.
 */

public class FoodSvcTest extends BaseTestCase {

    @Autowired
    FoodSvc foodSvc;

    @Autowired
    MongoOperations db;

    @Autowired
    TestHelper testHelper;
    @Before
    public void setup(){
        testHelper.dropCreateSchema();
    }

    @Test public void testGetAll_Empty() {
        List<Food> foods = foodSvc.getAll();
        Assert.assertTrue(foods.isEmpty());
    }

    @Test public void testGetAll() {
        Map<String,List<Food>> seededFoods = testHelper.foodSeeder()
                .generic(3)
                .seed().harvest();

        List<Food> foods = foodSvc.getAll();
        Assert.assertTrue(foods.size() == 3);
    }

    @Test
    public void searchFood() {
        Map<String,List<Food>> seeds = testHelper.foodSeeder()
                .generic(1)
                .seed().harvest();

        Assert.assertTrue((foodSvc.searchFoodByName(seeds.get("DEFAULT").stream()
                .findAny().get()
                .getName()
                .substring(2))).size() > 0);
    }

    @Test public void addFood() {
        Food f = new Food();
        f.setName("foodey");
        f.setUnit("100g");
        f.setBrand("");
        f.setProtein(13.2f);
        f.setCarbs(7f);
        f.setFat(1);
        Food saved = foodSvc.createFood(f);
        Assert.assertTrue(saved.getId() != null);
    }

}
