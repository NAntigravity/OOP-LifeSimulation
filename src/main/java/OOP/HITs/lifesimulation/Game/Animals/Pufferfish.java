package OOP.HITs.lifesimulation.Game.Animals;

import OOP.HITs.lifesimulation.Game.Nature.WaterLily;
import OOP.HITs.lifesimulation.Game.Tiles.Water;

import java.util.List;
import java.util.Vector;

public class Pufferfish extends Herbivore {
    public Pufferfish() {
        super();
        entityType = Pufferfish.class;
        suitableTile = new Vector<>(List.of(Water.class));
        hp = 20;
        foodSearchArea = 2;
        eatableEntities = new Vector<>(List.of(WaterLily.class));
    }
}
