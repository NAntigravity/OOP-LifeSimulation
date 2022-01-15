package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Buildings.House;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import org.jetbrains.annotations.NotNull;

public class HumanMale extends Human {
    public HumanMale() {
        super();
        entityType = HumanMale.class;
        hp = 100;
        foodSearchArea = 4;
    }

    public void buildHouse(@NotNull EntityControlService entityControlService){
        House house = new House(x, y);
        entityControlService.spawnEntityOnCoordinates(house, x, y);
    }

    @Override
    public void live(Map map, EntityControlService entityControlService) {
        var randValue = Math.random();
        if (randValue < 0.01){
            buildHouse(entityControlService);
        }
        super.live(map, entityControlService);
    }
}
