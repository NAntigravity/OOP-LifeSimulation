package com.example.lifesimulation.GameObjects.Tiles;

import java.io.Serializable;

public class Tile implements Serializable {
    protected TileType tileType;

    public Tile() {
        tileType = TileType.TILE;
    }

    public TileType getTileType() {
        return tileType;
    }
}
