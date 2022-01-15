package com.example.lifesimulation.Game.Nature;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.Tiles.Tile;

import java.util.List;
import java.util.Vector;

public abstract class Plant extends Entity {
    protected Vector<Class> suitableTile;

    public Plant() {
        super();
        entityType = Plant.class;
        suitableTile = new Vector<>(List.of(Tile.class));
    }
}
