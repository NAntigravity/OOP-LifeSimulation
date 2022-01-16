package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;

public interface IWork {
    void work(Human human, EntityControlService entityControlService, Map map);
}
