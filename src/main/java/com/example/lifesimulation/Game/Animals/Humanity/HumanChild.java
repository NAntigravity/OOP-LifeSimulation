package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;

public class HumanChild implements IAge {
    public final Class AgeType = HumanChild.class;
    @Override
    public void humanEat(Human human, EntityControlService entityControlService) {
        //Specific logic of eating process
    }

    @Override
    public void humanReproduction(Human human, EntityControlService entityControlService) {
        //Do nothing
    }

    @Override
    public void liveSpecificLife(Human human, Map map, EntityControlService entityControlService) {
        //Do nothing
    }
}
