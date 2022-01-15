package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Buildings.House;
import com.example.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public abstract class Human extends Animal {
    protected House house;
    public Human() {
        super();
        entityType = Human.class;
        hp = 100;
        foodSearchArea = 4;
        suitableTile = new Vector<>(List.of(Desert.class));
        house = null;
    }

    public House getHouse(){
        return house;
    }

    public void setHouse(House house){
        this.house = house;
    }
}
