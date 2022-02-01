package OOP.HITs.lifesimulation.Game.Animals;

import OOP.HITs.lifesimulation.Game.Nature.Plant;

import java.util.List;
import java.util.Vector;

public abstract class Herbivore extends Animal {
    public Herbivore() {
        super();
        entityType = Herbivore.class;
        eatableEntities = new Vector<>(List.of(Plant.class));
    }
}
