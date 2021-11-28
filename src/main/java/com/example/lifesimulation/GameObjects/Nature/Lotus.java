package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Tiles.Water;

import java.util.List;
import java.util.TreeSet;

public class Lotus extends Plant {
    public Lotus() {
        entityType = Lotus.class;
        suitableTile = new TreeSet<>(List.of(Water.class));
    }
}
