package com.example.cvolk.zooproject.model.animals;

import com.example.cvolk.zooproject.model.food.Food;

public abstract class Animal {

    private int energyLevel;

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

    @Override
    public String toString() {
        return "Energy level is " + energyLevel;
    }
}