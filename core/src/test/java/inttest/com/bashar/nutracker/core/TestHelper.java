package inttest.com.bashar.nutracker.core;
import com.bashar.nutracker.core.dm.Entry;
import com.bashar.nutracker.core.dm.Food;
import com.bashar.nutracker.core.repo.api.EntryRepoApi;
import com.bashar.nutracker.core.repo.api.FoodRepoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created by Bashar on 2017-09-10.
 */

@Component
public class TestHelper {

    @Autowired
    MongoOperations db;

    @Autowired
    FoodRepoApi foodRepo;

    @Autowired
    EntryRepoApi entryRepo;

    FoodSeeder foodSeeder() {
        return new FoodSeeder();
    }
    EntrySeeder entrySeeder() {
        return new EntrySeeder();
    }

    TestHelper(){

    }

    public void dropCreateSchema(){
        db.dropCollection(Entry.class);
        db.dropCollection(Food.class);
        db.createCollection(Entry.class);
        db.createCollection(Food.class);
    }

    abstract class Seeder<T> {
        abstract Map<String, List<T>> seed();
    }

    class FoodSeeder extends Seeder<Food> {

        private final Map<String, List<Food>> foodSeeds = new HashMap<>();

        public FoodSeeder defaultFood(int count){
            for(int i = 1; i <= count; i++) {
                Food food = new Food();
                food.setName("testFood_" + i);
                food.setCarbs(20);
                food.setUnit("100g");
                food.setProtein(23);
                if (!foodSeeds.containsKey("DEFAULT")) {
                    foodSeeds.put("DEFAULT", new ArrayList<>());
                }
                foodSeeds.get("DEFAULT").add(food);
            }
            return this;
        }

        public FoodSeeder specific(Food f){
            if (!foodSeeds.containsKey("SPECIFIC")) {
                foodSeeds.put("SPECIFIC", new ArrayList<>());
            }
            foodSeeds.get("SPECIFIC").add(f);
            return this;
        }

        public FoodSeeder random(Food f){
            throw new NotImplementedException();
        }

        public Map<String, List<Food>> seed(){
            doSeed();
            return foodSeeds;
        }

        private void doSeed(){
            for(Map.Entry<String, List<Food>> pair: this.foodSeeds.entrySet()) {
                for(Food f: pair.getValue()) {
                    foodRepo.create(f);
                }
            }

        }
    }

    class EntrySeeder extends Seeder<Entry> {

        private final Map<String, List<Entry>> entrySeeds = new HashMap<>();

        public EntrySeeder defaultEntry(int count, List<Food> foodSeeds){
            for(int i = 1; i <= count; i++) {
                Entry e = new Entry();
                e.setAmount(i);
                e.setFood(foodSeeds.size() < i ? foodSeeds.get(0) : foodSeeds.get(i));
                e.setCreatedAt(new Date());
                if (!entrySeeds.containsKey("DEFAULT")) {
                    entrySeeds.put("DEFAULT", new ArrayList<>());
                }
                entrySeeds.get("DEFAULT").add(e);
            }
            return this;
        }

        public EntrySeeder specific(Entry e){
            if (!entrySeeds.containsKey("SPECIFIC")) {
                entrySeeds.put("SPECIFIC", new ArrayList<>());
            }
            entrySeeds.get("SPECIFIC").add(e);
            return this;
        }

        public EntrySeeder random(Entry e){
            throw new NotImplementedException();
        }

        public Map<String, List<Entry>> seed(){
            doSeed();
            return entrySeeds;
        }

        private void doSeed(){
            for(Map.Entry<String, List<Entry>> pair: this.entrySeeds.entrySet()) {
                for(Entry e: pair.getValue()) {
                    entryRepo.create(e);
                }
            }

        }
    }
}
