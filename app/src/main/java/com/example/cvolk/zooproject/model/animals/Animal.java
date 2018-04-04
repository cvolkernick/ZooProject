package com.example.cvolk.zooproject.model.animals;

import com.example.cvolk.zooproject.model.food.Food;

import java.io.Serializable;

public abstract class Animal implements Serializable {

    private int energyLevel;
    private int weight;

    public int getWeight() { return weight; }

    public void setWeight(int weight) { this.weight = weight; }

    public int getEnergyLevel() {
        return energyLevel;
    }

    protected void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void makeSound() {
        setEnergyLevel(energyLevel - 3);
    }

    public void eat(Food food) {
        setEnergyLevel(energyLevel + 5);
    }

    public void sleep() {
        setEnergyLevel(energyLevel + 10);
    }

    public String getSimpleClassName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "Energy level is " + energyLevel;
    }
}