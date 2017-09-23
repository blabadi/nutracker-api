package inttest.com.bashar.nutracker.core;
import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.dm.Food;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by Bashar on 2017-09-10.
 */


public class TestHelper {

    static Food food;

    public static void dropCreateSchema(MongoOperations db){
        db.dropCollection(Entry.class);
        db.dropCollection(Food.class);
        db.createCollection(Entry.class);
        db.createCollection(Food.class);

        food = new Food();
        food.setName("testFood");
        food.setCarbs(20);
        food.setUnit("100g");
        food.setProtein(23);
        db.save(food);
    }
}
