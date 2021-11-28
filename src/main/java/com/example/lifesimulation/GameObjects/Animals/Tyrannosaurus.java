package com.example.lifesimulation.GameObjects.Animals;

import java.util.List;
import java.util.TreeSet;

public class Tyrannosaurus extends Predator {
    public Tyrannosaurus() {
        super();
        entityType = Tyrannosaurus.class;
        eatableEntities = new TreeSet<>(List.of(Diplodocus.class, Stegosaurus.class, Triceratops.class, Human.class));

    }
}
