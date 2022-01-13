package com.example.lifesimulation;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.Map;

import java.util.Vector;

public class LifeSimulationViewModel {
    public Map map;
    public Vector<Entity> entities;
    public LifeSimulationViewModel(Map map, Vector<Entity> entities) {
        this.map = map;
        this.entities = entities;
    }
}
