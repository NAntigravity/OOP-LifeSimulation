package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class Pufferfish extends Herbivore {
    public Pufferfish() {
        super();
        entityType = Pufferfish.class;
        suitableTileForMoving = new Vector<>(List.of(Water.class));
    }
}
