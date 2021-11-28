package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Tiles.Desert;
import com.example.lifesimulation.GameObjects.Tiles.Earth;

import java.util.List;
import java.util.TreeSet;

public class Mushroom extends Plant implements Healing {
    public Mushroom() {
        entityType = Mushroom.class;
        suitableTile = new TreeSet<>(List.of(Desert.class, Earth.class));
    }
}
