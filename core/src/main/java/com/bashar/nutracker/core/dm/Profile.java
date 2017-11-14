package com.bashar.nutracker.core.dm;

/**
 * Created by Bashar on 2017-11-13.
 */
public class Profile {
    private String firstName;
    private String lastName;
    private int heightCm;
    private float weight;
    private float fatPercentage;
    private NutritionalDailyTargets targets;

    private class NutritionalDailyTargets {
        private int calories;
        private int fats;
        private int carbs;
        private int protein;

        public NutritionalDailyTargets calories(int calories) {
            this.calories = calories;
            return this;
        }

        public NutritionalDailyTargets fats(int fats) {
            this.fats = fats;
            return this;
        }

        public NutritionalDailyTargets carbs(int carbs) {
            this.carbs = carbs;
            return this;
        }

        public NutritionalDailyTargets protein(int protein) {
            this.protein = protein;
            return this;
        }

        public int getCalories() {
            return calories;
        }

        public int getFats() {
            return fats;
        }

        public int getCarbs() {
            return carbs;
        }

        public int getProtein() {
            return protein;
        }
    }

    public Profile firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Profile lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Profile heightCm(int heightCm) {
        this.heightCm = heightCm;
        return this;
    }

    public Profile weight(float weight) {
        this.weight = weight;
        return this;
    }

    public Profile fatPercentage(float fatPercentage) {
        this.fatPercentage = fatPercentage;
        return this;
    }

    public Profile targets(NutritionalDailyTargets targets) {
        this.targets = targets;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public float getWeight() {
        return weight;
    }

    public float getFatPercentage() {
        return fatPercentage;
    }

    public NutritionalDailyTargets getTargets() {
        return targets;
    }
}
