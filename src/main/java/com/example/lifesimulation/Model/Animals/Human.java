package com.example.lifesimulation.Model.Animals;

public class Human extends Animal {
    public Human() {
        super();
        entityType = Human.class;
        //eatableEntities = new TreeSet<>(List.of(Turtle.class, Pufferfish.class, Mushroom.class, IceHerb.class));
    }
}