package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Tiles.Desert;
import com.example.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class Wolf extends Predator {
    public Wolf() {
        super();
        entityType = Wolf.class;
        suitableTile = new Vector<>(List.of(Desert.class));
        hp = 50;
        foodSearchArea = 5;
    }
}
