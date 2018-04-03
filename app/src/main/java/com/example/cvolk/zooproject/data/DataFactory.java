package com.example.cvolk.zooproject.data;

import com.example.cvolk.zooproject.model.animals.Animal;
import com.example.cvolk.zooproject.model.animals.Lizard;
import com.example.cvolk.zooproject.model.animals.Monkey;
import com.example.cvolk.zooproject.model.animals.Snake;
import com.example.cvolk.zooproject.model.animals.Tiger;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    private static List<Animal> animalsList;

    public static void initAnimals() {
        animalsList = new ArrayList<>();

        Lizard l = new Lizard();
        Monkey m = new Monkey();
        Snake s = new Snake();
        Tiger t = new Tiger();

        animalsList.add(l);
        animalsList.add(m);
        animalsList.add(s);
        animalsList.add(t);
    }

    public static List<Animal> getAnimalsList() {
        return animalsList;
    }

    public static List<String> getAnimalTypes() {
        List<String> animalTypes = new ArrayList<>();

        for (Animal a : animalsList) {
            if (!animalTypes.contains(a.getClass().getCanonicalName())){
                animalTypes.add(a.getClass().getCanonicalName());
            }
        }

        return animalTypes;
    }
}
