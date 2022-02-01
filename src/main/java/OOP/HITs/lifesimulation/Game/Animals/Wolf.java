package OOP.HITs.lifesimulation.Game.Animals;

import OOP.HITs.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public class Wolf extends Predator {
    public Wolf() {
        super();
        entityType = Wolf.class;
        suitableTile = new Vector<>(List.of(Desert.class));
        hp = 50;
        foodSearchArea = 5;
    }
}
