package com.example.cvolk.zooproject.model.animals;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class Snake extends Reptile {

    protected static int population = 0;
    private int weight;

    public Snake(int weight) {
        population++;
        setWeight(weight);
    }

    public int getWeight() { return weight; }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void makeSound() {
        super.makeSound();
        Log.d(TAG, "makeSound: *hiss*");
    }
}
