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

        Lizard l = new Lizard(55);
        Monkey m = new Monkey(25);
        Snake s = new Snake(5);
        Tiger t = new Tiger(175);
        Tiger t2 = new Tiger(125);

        animalsList.add(l);
        animalsList.add(m);
        animalsList.add(s);
        animalsList.add(t);
        animalsList.add(t2);
    }

    public static List<Animal> getAnimalsList() {
        return animalsList;
    }

    public static List<String> getAnimalTypes() {
        List<String> animalTypes = new ArrayList<>();

        for (Animal a : animalsList) {
            String[] parts = a
                    .getClass()
                    .getSuperclass()
                    .getCanonicalName()
                    .split("\\.");
            String typeName = parts[parts.length - 1];
            if (!animalTypes.contains(typeName)){
                animalTypes.add(typeName);
            }
        }

        return animalTypes;
    }

    public static int getTypeCount(String typeName) {
        int typeCount = 0;

        for (Animal a : animalsList) {
            String[] parts = a.getClass().getSuperclass().getCanonicalName().split("\\.");
            String currentTypeName = parts[parts.length - 1];

            if (currentTypeName.equals(typeName)) {
                typeCount++;
            }
        }
        return typeCount;
    }

    public static List<Animal> getAnimalsOfType(String type) {
        List<Animal> filteredTypes = new ArrayList<>();

        for (Animal a : animalsList) {
            String[] typeParts = a.getClass().getSuperclass().getCanonicalName().split("\\.");
            String currentType = typeParts[typeParts.length - 1];

            if (currentType.equals(type)) {
                filteredTypes.add(a);
            }
        }

        return filteredTypes;
    }
}
