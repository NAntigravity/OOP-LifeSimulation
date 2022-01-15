package com.example.lifesimulation.Game.Tiles;

import java.util.Collections;

public class Water extends LiquidTile {
    public Water() {
        super();
        tileType = Collections.singleton(Water.class);
    }
}
