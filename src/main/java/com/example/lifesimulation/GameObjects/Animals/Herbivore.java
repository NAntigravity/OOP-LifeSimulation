package com.example.lifesimulation.GameObjects.Animals;

import com.example.lifesimulation.GameObjects.Nature.Mushroom;
import com.example.lifesimulation.GameObjects.Nature.IceHerb;
import com.example.lifesimulation.GameObjects.Nature.Thistle;
import com.example.lifesimulation.GameObjects.Nature.CarnivorousPlant;

import java.util.List;
import java.util.TreeSet;

public class Herbivore extends Animal {
    public Herbivore() {
        super();
        entityType = Herbivore.class;
        eatableEntities = new TreeSet<>(List.of(Mushroom.class, IceHerb.class, Thistle.class, CarnivorousPlant.class));
    }
}
