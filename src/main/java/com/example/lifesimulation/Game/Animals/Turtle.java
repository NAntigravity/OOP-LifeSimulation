package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Nature.Plant;
import com.example.lifesimulation.Game.Tiles.Desert;
import com.example.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class Turtle extends Herbivore {
    public Turtle() {
        super();
        entityType = Turtle.class;
        suitableTileForMoving = new Vector<>(List.of(Desert.class, Water.class));
        eatableEntities = new Vector<>(List.of(Plant.class));
    }
}
