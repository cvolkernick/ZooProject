package com.example.cvolk.zooproject.model.animals;

import android.util.Log;

import com.example.cvolk.zooproject.model.food.Food;

import static android.content.ContentValues.TAG;

public class Monkey extends Animal {

    protected static int population = 0;

    public Monkey() {
        population++;
    }

    @Override
    public void eat(Food food) {
        this.setEnergyLevel(this.getEnergyLevel() + 2);
    }

    @Override
    public void makeSound() {
        Log.d(TAG, "makeSound: *monkey noises*");
        this.setEnergyLevel(this.getEnergyLevel() - 4);
    }

    public void play() {
        if (this.getEnergyLevel() >= 8) {
            Log.d(TAG, "play: Oooo Oooo Oooo");
            this.setEnergyLevel(this.getEnergyLevel() - 8);
        }
        else {
            Log.d(TAG, "play: Monkey is too tired.");
        }
    }
}
