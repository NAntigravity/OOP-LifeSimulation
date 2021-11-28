package com.example.lifesimulation.GameObjects.Tiles;

import java.util.HashSet;
import java.util.List;

public class LiquidTile extends Tile {
    public LiquidTile() {
        super();
        tileType = new HashSet<>(List.of(Ice.class, Water.class));
    }
}
