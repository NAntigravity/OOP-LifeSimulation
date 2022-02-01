package OOP.HITs.lifesimulation.Game.Animals;

import OOP.HITs.lifesimulation.Game.Tiles.Desert;
import OOP.HITs.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class Turtle extends Herbivore {
    public Turtle() {
        super();
        entityType = Turtle.class;
        suitableTile = new Vector<>(List.of(Desert.class, Water.class));
        hp = 30;
        foodSearchArea = 2;
    }
}
