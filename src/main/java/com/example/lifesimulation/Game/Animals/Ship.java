package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public class Ship extends Animal {
    public Ship() {
        super();
        entityType = Ship.class;
        suitableTile = new Vector<>(List.of(Desert.class));
        hp = 30;
    }
}
