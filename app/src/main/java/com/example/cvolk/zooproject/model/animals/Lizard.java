package com.example.cvolk.zooproject.model.animals;

public class Lizard extends Reptile {

    protected static int population = 0;

    public Lizard(int weight) {
        population++;
        this.setWeight(weight);
    }
}
