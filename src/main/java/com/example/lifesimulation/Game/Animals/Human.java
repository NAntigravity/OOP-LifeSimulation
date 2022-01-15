package com.example.lifesimulation.Game.Animals;

public abstract class Human extends Animal {
    public Human() {
        super();
        entityType = Human.class;
        hp = 100;
        foodSearchArea = 4;
    }
}
