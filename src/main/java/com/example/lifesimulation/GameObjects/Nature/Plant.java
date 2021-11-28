package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Entity;
import com.example.lifesimulation.GameObjects.SeasonDependent;
import com.example.lifesimulation.GameObjects.Tiles.Tile;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Plant extends Entity implements SeasonDependent {
    protected Set<Class> suitableTile;
    public Plant() {
        super();
        entityType = Plant.class;
        suitableTile = new TreeSet<>(List.of(Tile.class));
    }
}
