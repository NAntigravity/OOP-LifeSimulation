package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;

public interface IAge {
    void humanEat(Human human, EntityControlService entityControlService);
    void humanReproduction(Human human, EntityControlService entityControlService);
    void liveSpecificLife(Human human, Map map, EntityControlService entityControlService);
}
