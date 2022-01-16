package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.Animals.Sex;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;

public class HumanFemale extends Human {
    public HumanFemale(IAge age) {
        super(age);
        entityType = HumanFemale.class;
        hp = 100;
        foodSearchArea = 4;
        sex = Sex.female;
        inventorySpace = 300;
    }

    @Override
    public void liveSpecificSexLife(Map map, EntityControlService entityControlService) {
        //Do nothing
    }
}
