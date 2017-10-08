package inttest.com.bashar.nutracker.core;
import com.bashar.nutracker.core.CoreConfig;
import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.service.EntrySvc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Bashar on 2017-09-10.
 */

public class EntrySvcTest extends BaseTestCase {

    @Autowired
    MongoOperations db;

    @Autowired
    EntrySvc svc;


    @Before
    public void setup() {
        TestHelper.dropCreateSchema(db);
    }

    @Test
    public void testGetAll() {

    }

    @Test public void testCreateEntry(){
        Entry e = new Entry();
        e.setAmount(1);
        e.setCreatedAt(new Date());

        //set the test food
        Query q = new Query();
        q.addCriteria(Criteria.where("name").is(TestHelper.food.getName()));
        e.setFood(db.findOne(q, Food.class));

        Entry created = svc.create(e);

        Entry saved = db.findById(created.getId(), Entry.class);

        Assert.assertNotNull(saved);
    }
}
