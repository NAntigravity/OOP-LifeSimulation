package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Tiles.Water;

import java.util.List;
import java.util.TreeSet;

public class Seaweed extends Plant {
    public Seaweed() {
        entityType = Seaweed.class;
        suitableTile = new TreeSet<>(List.of(Water.class));
    }
}
