package com.example.lifesimulation.Game.Buildings;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.Food.Food;
import com.example.lifesimulation.Game.Tiles.Desert;

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
