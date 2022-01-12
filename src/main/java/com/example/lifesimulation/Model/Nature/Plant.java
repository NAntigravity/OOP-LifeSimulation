package com.example.lifesimulation.Model.Nature;

import com.example.lifesimulation.Model.Entity;
import com.example.lifesimulation.Model.SeasonDependent;
import com.example.lifesimulation.Model.Tiles.Tile;

import java.util.TreeSet;

public abstract class Plant extends Entity implements SeasonDependent {
    protected TreeSet<Tile> suitableTile;
    public Plant() {
        super();
        entityType = Plant.class;
       // suitableTile = new TreeSet<>(List.of(Tile.class));
    }
}
