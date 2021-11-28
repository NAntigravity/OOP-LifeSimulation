package com.example.lifesimulation.GameObjects.Animals;

import java.util.List;
import java.util.TreeSet;

public class Predator extends Animal {
    public Predator() {
        super();
        entityType = Predator.class;
        eatableEntities = new TreeSet<>(List.of(Herbivore.class));
    }
}
