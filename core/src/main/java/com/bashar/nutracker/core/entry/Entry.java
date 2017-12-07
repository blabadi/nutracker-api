package com.bashar.nutracker.core.entry;

import com.bashar.nutracker.core.food.Food;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Bashar on 2017-08-27.
 */
@Document(collection = "entries")
@Entity
public class Entry {

    @Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
//    @Field(value = "_id")
    private String id;

    private float amount;

    private Date createdAt;

    private String meal;

    private Food food;

    private String owner;

    public Entry amount(float amount) {
        this.setAmount(amount);
        return this;
    }

    public Entry createdAt(Date createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public Entry meal(String meal) {
        this.setMeal(id);
        return this;
    }
    public Entry food(Food food) {
        this.setFood(food);
        return this;
    }

    public Entry owner(String owner) {
        this.setOwner(owner);
        return this;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createAt) {
        this.createdAt = createAt;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Entry{");
        sb.append("id='").append(id).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", meal='").append(meal).append('\'');
        sb.append(", food=").append(food);
        sb.append('}');
        return sb.toString();
    }
}
