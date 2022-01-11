package com.example.lifesimulation.GameObjects.Animals;

public abstract class Herbivore extends Animal {
    public Herbivore() {
        super();
        entityType = Herbivore.class;
        //eatableEntities = new TreeSet<>(List.of());
    }
}
