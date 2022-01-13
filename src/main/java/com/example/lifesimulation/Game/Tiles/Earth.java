package com.example.lifesimulation.Game.Tiles;

import java.util.Collections;

public class Earth extends SolidTile {
    public Earth() {
        super();
        tileType = Collections.singleton(Earth.class);
    }
}
