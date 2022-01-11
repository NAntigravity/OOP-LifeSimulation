package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Entity;
import com.example.lifesimulation.GameObjects.SeasonDependent;
import com.example.lifesimulation.GameObjects.Tiles.Tile;

import java.util.TreeSet;

public abstract class Plant extends Entity implements SeasonDependent {
    protected TreeSet<Tile> suitableTile;
    public Plant() {
        super();
        entityType = Plant.class;
       // suitableTile = new TreeSet<>(List.of(Tile.class));
    }
}
