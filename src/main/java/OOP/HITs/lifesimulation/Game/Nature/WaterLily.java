package OOP.HITs.lifesimulation.Game.Nature;

import OOP.HITs.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class WaterLily extends Plant {
    public WaterLily() {
        entityType = WaterLily.class;
        suitableTile = new Vector<>(List.of(Water.class));
        hp = 20;
    }
}
