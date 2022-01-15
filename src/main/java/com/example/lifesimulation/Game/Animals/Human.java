package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Entity;

import java.util.List;
import java.util.Vector;

public abstract class Human extends Animal {
    public Human() {
        super();
        entityType = Human.class;
        eatableEntities = new Vector<>(List.of(Entity.class));
        hp = 100;
    }
}
