package com.example.lifesimulation.Game.Nature;

import com.example.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public class Grass extends Plant {
    public Grass() {
        entityType = Grass.class;
        suitableTile = new Vector<>(List.of(Desert.class));
    }
}
