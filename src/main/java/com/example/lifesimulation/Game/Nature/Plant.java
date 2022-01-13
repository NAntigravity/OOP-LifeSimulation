package com.example.lifesimulation.Game.Nature;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.SeasonDependent;

import java.util.Vector;

public abstract class Plant extends Entity implements SeasonDependent {
    protected Vector<Class> suitableTile;
    public Plant() {
        super();
        entityType = Plant.class;
       // suitableTile = new TreeSet<>(List.of(Tile.class));
    }
}
