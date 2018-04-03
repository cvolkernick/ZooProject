package com.example.cvolk.zooproject.model.animals;

import android.util.Log;

import com.example.cvolk.zooproject.model.food.Food;
import com.example.cvolk.zooproject.model.food.Grain;

import static android.content.ContentValues.TAG;

public class Tiger extends Cat {

    protected static int population = 0;

    public Tiger() {
        population++;
    }

    @Override
    public void makeSound() {
        super.makeSound();
        Log.d(TAG, "makeSound: *roar*");
    }

    @Override
    public void sleep() {
        this.setEnergyLevel(this.getEnergyLevel() + 5);
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Grain)) {
            super.eat(food);
        }
        else {
            Log.d(TAG, "eat: Tigers can't eat grains!");
        }
    }
}
