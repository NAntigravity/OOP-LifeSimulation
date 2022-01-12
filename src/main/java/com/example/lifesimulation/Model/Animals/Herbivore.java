package com.example.lifesimulation.Model.Animals;

public abstract class Herbivore extends Animal {
    public Herbivore() {
        super();
        entityType = Herbivore.class;
        //eatableEntities = new TreeSet<>(List.of());
    }
}
