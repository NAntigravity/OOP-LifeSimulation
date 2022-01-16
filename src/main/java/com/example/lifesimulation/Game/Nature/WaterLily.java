package com.example.lifesimulation.Game.Nature;

import com.example.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class WaterLily extends Plant {
    public WaterLily() {
        entityType = WaterLily.class;
        suitableTile = new Vector<>(List.of(Water.class));
    }
}
