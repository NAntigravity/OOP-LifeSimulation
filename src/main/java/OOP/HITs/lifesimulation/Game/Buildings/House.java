package OOP.HITs.lifesimulation.Game.Buildings;

import OOP.HITs.lifesimulation.Game.Entity;
import OOP.HITs.lifesimulation.Game.Food.Food;
import OOP.HITs.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public class House extends Entity {
    protected Village village;

    public House(int x, int y) {
        entityType = House.class;
        hp = 200;
        suitableTile = new Vector<>(List.of(Desert.class));
        village = null;
        this.x = x;
        this.y = y;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public Food getHarvest() {
        return null;
    }
}
