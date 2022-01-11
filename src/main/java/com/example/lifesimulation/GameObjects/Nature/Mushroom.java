package com.example.lifesimulation.GameObjects.Nature;

public class Mushroom extends Plant implements Healing {
    public Mushroom() {
        entityType = Mushroom.class;
        //suitableTile = new TreeSet<>(List.of(Desert.class, Earth.class));
    }
}
