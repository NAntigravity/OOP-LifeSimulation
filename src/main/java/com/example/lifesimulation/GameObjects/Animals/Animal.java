package com.example.lifesimulation.GameObjects.Animals;

import com.example.lifesimulation.GameObjects.Entity;
import com.example.lifesimulation.GameObjects.EntityType;

import java.util.*;

public class Animal extends Entity {
    protected Set<EntityType> eatableEntities;

    public Animal() {
        super();
        entityType = EntityType.ANIMAL;
        eatableEntities = new TreeSet<>(List.of(EntityType.ANIMAL));

    }
}
