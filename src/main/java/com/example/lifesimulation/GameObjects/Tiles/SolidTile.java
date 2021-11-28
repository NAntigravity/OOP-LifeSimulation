package com.example.lifesimulation.GameObjects.Tiles;

import java.util.HashSet;
import java.util.List;

public class SolidTile extends Tile {
    public SolidTile() {
        super();
        tileType = new HashSet<>(List.of(Earth.class, Snow.class, Desert.class));
    }
}
