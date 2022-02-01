package OOP.HITs.lifesimulation.Game.Animals;

import java.util.List;
import java.util.Vector;

public abstract class Predator extends Animal {
    public Predator() {
        super();
        entityType = Predator.class;
        eatableEntities = new Vector<>(List.of(Animal.class));
    }
}
