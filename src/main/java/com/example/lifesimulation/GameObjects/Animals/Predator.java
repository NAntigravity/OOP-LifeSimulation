package com.example.lifesimulation.GameObjects.Animals;

public abstract class Predator extends Animal {
    public Predator() {
        super();
        entityType = Predator.class;
        //eatableEntities = new TreeSet<>(List.of(Herbivore.class));
    }
}
