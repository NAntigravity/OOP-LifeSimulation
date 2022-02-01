package OOP.HITs.lifesimulation.Game.Nature;

import OOP.HITs.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public class Grass extends Plant {
    public Grass() {
        entityType = Grass.class;
        suitableTile = new Vector<>(List.of(Desert.class));
        hp = 20;
    }
}
