package inttest.com.bashar.nutracker.core;

import com.bashar.nutracker.core.CoreConfig;
import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.service.FoodSvc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Bashar on 2017-09-03.
 */

public class FoodSvcTest extends BaseTestCase {

    @Autowired
    FoodSvc foodSvc;

    @Autowired
    MongoOperations db;

    @Before
    public void setup(){
        TestHelper.dropCreateSchema(db);
    }


    @Test public void testGetAll() {
        Assert.assertFalse(foodSvc.getAll().isEmpty());
    }


    @Test public void addFood() {
        Food f = new Food();
        f.setName("foodey");
        f.setUnit("100g");
        f.setBrand("");
        f.setProtein(13.2f);
        f.setCarbs(7f);
        f.setFat(1);

        foodSvc.createFood(f);
    }

}
