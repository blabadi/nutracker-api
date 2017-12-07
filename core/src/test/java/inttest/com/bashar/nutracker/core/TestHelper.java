package inttest.com.bashar.nutracker.core;
import com.bashar.nutracker.core.entry.Entry;
import com.bashar.nutracker.core.food.Food;
import com.bashar.nutracker.core.entry.EntryRepoApi;
import com.bashar.nutracker.core.food.FoodRepoApi;
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

    class ChildSeeder<W> {

    }

    abstract class Seeder<T> {

        protected final Map<String, List<T>> seeds = new HashMap<>();
        public Map<Class<?>, Seeder<?>> childSeeders = new HashMap<>();

        abstract void doSeed(T t);

        protected Seeder<T> childSeeders(Map<Class<?>, Seeder<?>> childSeeders){
            this.childSeeders = childSeeders;
            return this;
        }

        protected <Y> Seeder<Y> childSeeder(Class<Y> clazz) {
            if (this.childSeeders.get(clazz) != null) {
                return (Seeder<Y>) this.childSeeders.get(clazz);
            }
            return null;
        }

        protected abstract Seeder<T> generic(int times);

        public Seeder<T> seed(){
            for(Map.Entry<String, List<T>> pair: this.seeds.entrySet()) {
                pair.getValue().forEach(this::doSeed);
            }
            return this;
        }

        public Seeder<T> specific(T f){
            if (!seeds.containsKey("SPECIFIC")) {
                seeds.put("SPECIFIC", new ArrayList<>());
            }
            seeds.get("SPECIFIC").add(f);
            return this;
        }

        public Map<String, List<T>> harvest(){
            return seeds;
        };

        public T harvestFirst(){
           return seeds.entrySet()
                   .stream()
                   .findFirst()
                   .get()
                   .getValue()
                   .stream()
                   .findFirst().get();
        };
    }

    class FoodSeeder extends Seeder<Food> {
        public FoodSeeder generic(int count){
            for(int i = 1; i <= count; i++) {
                Food food = new Food();
                food.setName("testFood_" + i);
                food.setCarbs(20);
                food.setUnit("100g");
                food.setProtein(23);
                if (!seeds.containsKey("DEFAULT")) {
                    seeds.put("DEFAULT", new ArrayList<>());
                }
                seeds.get("DEFAULT").add(food);
            }
            return this;
        }

        public FoodSeeder random(Food f){
            throw new NotImplementedException();
        }

        void doSeed(Food f){
            foodRepo.create(f);
        }
    }

    class EntrySeeder extends Seeder<Entry> {
        public EntrySeeder() {
            this.childSeeders.put(Food.class, foodSeeder());
        }

        public EntrySeeder generic(int count){
            for(int i = 1; i <= count; i++) {
                Entry e = new Entry();
                e.setAmount(i);
                e.owner("owner");
                e.setFood(this.childSeeder(Food.class).generic(1).harvestFirst());
                e.setCreatedAt(new Date());
                if (!seeds.containsKey("DEFAULT")) {
                    seeds.put("DEFAULT", new ArrayList<>());
                }
                seeds.get("DEFAULT").add(e);
            }
            return this;
        }

        public EntrySeeder random(Entry e){
            throw new NotImplementedException();
        }

        void doSeed(Entry e){
                entryRepo.create(e);
        }
    }
}
