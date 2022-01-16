package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Nature.WaterLily;
import com.example.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class Pufferfish extends Herbivore {
    public Pufferfish() {
        super();
        entityType = Pufferfish.class;
        suitableTile = new Vector<>(List.of(Water.class));
        hp = 20;
        foodSearchArea = 2;
        eatableEntities = new Vector<>(List.of(WaterLily.class));
    }
}
