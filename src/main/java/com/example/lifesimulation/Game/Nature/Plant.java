package com.example.lifesimulation.Game.Nature;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.Food.Food;
import com.example.lifesimulation.Game.Food.GreenFood;

public abstract class Plant extends Entity {
    public Plant() {
        super();
        entityType = Plant.class;
    }

    public Food getHarvest() {
        return new GreenFood(getHp());
    }
}
