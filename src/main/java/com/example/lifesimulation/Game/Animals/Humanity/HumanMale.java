package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.Animals.Sex;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;

public class HumanMale extends Human {

    public HumanMale(IAge age) {
        super(age);
        entityType = HumanMale.class;
        hp = 100;
        foodSearchArea = 4;
        sex = Sex.male;
    }

    @Override
    public void liveSpecificSexLife(Map map, EntityControlService entityControlService) {

    }

}
