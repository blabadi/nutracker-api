package inttest.com.bashar.nutracker.core;
import com.bashar.nutracker.core.CoreConfig;
import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.EntryRepoApi;
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
import java.util.List;
import java.util.Map;

/**
 * Created by Bashar on 2017-09-10.
 */

public class EntrySvcTest extends BaseTestCase {

    @Autowired
    MongoOperations db;

    @Autowired
    EntrySvc svc;

    @Autowired
    EntryRepoApi repo;

    @Autowired
    TestHelper testHelper;

    Map<String, List<Food>> foodSeeds;
    @Before
    public void setup() {
        testHelper.dropCreateSchema();
        foodSeeds = testHelper.foodSeeder().generic(2).seed().harvest();
    }

    @Test
    public void testGetAll() {
        Assert.assertTrue(svc.getEntries().size() == 0);
    }

    @Test
    public void testGetByPeriod() {
        Entry todayEntry = new Entry()
                .amount(1.2f)
                .createdAt(new Date())
                .food(foodSeeds.get("DEFAULT").stream().findFirst().get())
                .meal("Breakfast");

        Date weekBack = new Date(todayEntry.getCreatedAt().getTime());
        weekBack.setDate(todayEntry.getCreatedAt().getDate() - 7);

        Date twoDaysBack = new Date(todayEntry.getCreatedAt().getTime());
        twoDaysBack.setDate(todayEntry.getCreatedAt().getDate() - 2);

        Entry LastWeekEntry = new Entry()
                .amount(1.3f)
                .createdAt(weekBack)
                .food(foodSeeds.get("DEFAULT").stream().findFirst().get())
                .meal("Breakfast");

        this.testHelper.entrySeeder()
                .specific(todayEntry)
                .specific(LastWeekEntry)
                .seed();

        //Test case 1, two days back
        List<Entry> entries = svc.getEntries(twoDaysBack, todayEntry.getCreatedAt());
        System.out.println(entries);
        Assert.assertTrue("one entry only in the last two days",entries.size() == 1);

        //Test case 2, one week back
        entries = svc.getEntries(weekBack, new Date());
        System.out.println(entries);
        Assert.assertTrue("two entries should be found since last week", entries.size() == 2);


    }

    @Test public void testUpdateEntry(){
        Entry defaultEntry = this.testHelper.entrySeeder()
                .generic(1)
                .seed()
                .harvestFirst();

        defaultEntry.setAmount(20);
        defaultEntry.setFood(null);
        this.svc.update(defaultEntry);

        Entry saved = db.findById(defaultEntry.getId(), Entry.class);
        Assert.assertTrue(saved.getAmount() == 20 && saved.getFood() != null);
    }

    @Test public void testDeleteEntry(){
        Entry defaultEntry = this.testHelper.entrySeeder()
                .generic(1)
                .seed()
                .harvestFirst();

        this.svc.delete(defaultEntry.getId());

        Entry deleted = db.findById(defaultEntry.getId(), Entry.class);
        Assert.assertTrue(deleted == null);
    }

    @Test public void testCreateEntry(){
        Entry e = new Entry();
        e.setAmount(1);
        e.setCreatedAt(new Date());

        //set the test food
        Query q = new Query();
        q.addCriteria(Criteria.where("name").is(foodSeeds.get("DEFAULT").stream().findFirst().get().getName()));
        e.setFood(db.findOne(q, Food.class));

        Entry created = svc.create(e);

        Entry saved = db.findById(created.getId(), Entry.class);

        Assert.assertNotNull(saved);
    }
}
