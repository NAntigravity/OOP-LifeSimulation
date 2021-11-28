package com.example.lifesimulation.GameObjects.Animals;

import com.example.lifesimulation.GameObjects.Nature.Mushroom;
import com.example.lifesimulation.GameObjects.Nature.IceHerb;
import com.example.lifesimulation.GameObjects.Nature.Thistle;
import com.example.lifesimulation.GameObjects.Nature.CarnivorousPlant;

import java.util.List;
import java.util.TreeSet;

public class Human extends Animal {
    public Human() {
        super();
        entityType = Human.class;
        eatableEntities = new TreeSet<>(List.of(Diplodocus.class, Stegosaurus.class, Triceratops.class, Mushroom.class, IceHerb.class, Thistle.class, CarnivorousPlant.class));
    }
}
