package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Tiles.Desert;
import com.example.lifesimulation.GameObjects.Tiles.Earth;

import java.util.List;
import java.util.TreeSet;

public class Thistle extends Plant implements Poisoning {
    public Thistle() {
        entityType = Thistle.class;
        suitableTile = new TreeSet<>(List.of(Desert.class, Earth.class));
    }
}
