package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Tiles.Ice;
import com.example.lifesimulation.GameObjects.Tiles.Snow;

import java.util.List;
import java.util.TreeSet;

public class IceHerb extends Plant implements Healing {
    public IceHerb() {
        entityType = IceHerb.class;
        suitableTile = new TreeSet<>(List.of(Snow.class, Ice.class));
    }
}
