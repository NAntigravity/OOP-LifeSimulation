package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Nature.Plant;

import java.util.List;
import java.util.Vector;

public abstract class Herbivore extends Animal {
    public Herbivore() {
        super();
        entityType = Herbivore.class;
        eatableEntities = new Vector<>(List.of(Plant.class));
    }
}
