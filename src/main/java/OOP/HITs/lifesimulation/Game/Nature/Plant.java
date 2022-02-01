package OOP.HITs.lifesimulation.Game.Nature;

import OOP.HITs.lifesimulation.Game.Entity;
import OOP.HITs.lifesimulation.Game.Food.Food;
import OOP.HITs.lifesimulation.Game.Food.GreenFood;

public abstract class Plant extends Entity {
    public Plant() {
        super();
        entityType = Plant.class;
    }

    public Food getHarvest() {
        return new GreenFood(getHp());
    }
}
