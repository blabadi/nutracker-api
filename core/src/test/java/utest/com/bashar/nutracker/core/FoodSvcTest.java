package utest.com.bashar.nutracker.core;

import com.bashar.nutracker.core.CoreConfig;
import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import com.bashar.nutracker.core.repo.jpa.FoodRepo;
import com.bashar.nutracker.core.service.FoodSvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
@ActiveProfiles("dev")
public class FoodSvcTest {

    @Autowired
    FoodSvc foodSvc;

    FoodRepoApi repo;

    @Before
    public void setup(){
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
        org.junit.Assert.assertTrue(foodsActual.size()> 0);
    }
}
