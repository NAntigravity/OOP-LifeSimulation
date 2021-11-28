package com.example.lifesimulation.GameObjects.Animals;

import com.example.lifesimulation.GameObjects.Entity;
import com.example.lifesimulation.GameObjects.Nature.Healing;
import com.example.lifesimulation.GameObjects.Nature.Poisoning;
import com.example.lifesimulation.GameObjects.SeasonDependent;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Animal extends Entity implements SeasonDependent {
    protected Set<Class> eatableEntities;

    public Animal() {
        super();
        entityType = Animal.class;
        eatableEntities = new TreeSet<>(List.of(Animal.class));
    }

    public boolean increaseOrrDecreaseHealth(Object object) {
        if (object instanceof Healing) {
            return false;
        } else if (object instanceof Poisoning) {
            return true;
        }
        return true;
    }
}
