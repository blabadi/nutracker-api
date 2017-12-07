package utest.com.bashar.nutracker.core;

import com.bashar.nutracker.core.food.Food;
import com.bashar.nutracker.core.food.FoodRepoApi;
import com.bashar.nutracker.core.food.FoodSvc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bashar on 2017-08-27.
 */
@RunWith(JUnit4.class)
public class FoodSvcTest {

    FoodSvc foodSvc;

    FoodRepoApi repo;

    @Before
    public void setup(){
        this.foodSvc = new FoodSvc();
        repo = Mockito.mock(FoodRepoApi.class);
        foodSvc.setFoodRepo(repo);
    }

    @Test
    public void testGetAll() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food());
        Mockito.when(repo.getAll()).thenReturn(foods);
        //test call
        List<Food> foodsActual = foodSvc.getAll();
        //assertion
        Assert.assertTrue(foodsActual.size()> 0);
    }
}
