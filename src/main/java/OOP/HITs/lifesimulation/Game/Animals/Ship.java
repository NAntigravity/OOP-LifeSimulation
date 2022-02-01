package OOP.HITs.lifesimulation.Game.Animals;

import OOP.HITs.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public class Ship extends Herbivore {
    public Ship() {
        super();
        entityType = Ship.class;
        suitableTile = new Vector<>(List.of(Desert.class));
        hp = 30;
        foodSearchArea = 3;
    }
}
