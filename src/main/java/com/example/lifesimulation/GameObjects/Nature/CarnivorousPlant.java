package com.example.lifesimulation.GameObjects.Nature;

import com.example.lifesimulation.GameObjects.Tiles.Desert;
import com.example.lifesimulation.GameObjects.Tiles.Earth;

import java.util.List;
import java.util.TreeSet;

public class CarnivorousPlant extends Plant implements Poisoning {
    public CarnivorousPlant() {
        entityType = CarnivorousPlant.class;
        suitableTile = new TreeSet<>(List.of(Desert.class, Earth.class));
    }
}
