package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.Animals.Animal;
import com.example.lifesimulation.Game.Buildings.House;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import com.example.lifesimulation.Game.Tiles.Desert;

import java.util.List;
import java.util.Vector;

public abstract class Human extends Animal {
    protected House house;
    protected IAge age;

    public Human(IAge age) {
        super();
        entityType = Human.class;
        hp = 100;
        foodSearchArea = 4;
        suitableTile = new Vector<>(List.of(Desert.class));
        house = null;
        this.age = age;
        reproductionTime = 5;
        reproductionCooldown = 5;
    }

    @Override
    public void live(Map map, EntityControlService entityControlService) {
        if (isDead) {
            return;
        }
        hunger--;
        if (hunger <= 0) {
            isDead = true;
            return;
        }
        moveToRandomDirection(map);
        age.humanEat(this, entityControlService);
        age.humanReproduction(this, entityControlService);
        age.liveSpecificLife(this, map, entityControlService);
    }

    public House getHouse(){
        return house;
    }

    public IAge getHumanAge(){
        return age;
    }

    public void setHouse(House house){
        this.house = house;
    }

    public abstract void liveSpecificSexLife(Map map, EntityControlService entityControlService);
}
