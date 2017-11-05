package utest.com.bashar.nutracker.core;

import com.bashar.nutracker.core.CoreConfig;
import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import com.bashar.nutracker.core.repo.jpa.FoodRepo;
import com.bashar.nutracker.core.service.FoodSvc;
import inttest.com.bashar.nutracker.core.TestConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
