package com.example.lifesimulation.GameObjects;

import java.io.Serializable;
import java.util.Vector;

public class ControlClass implements Serializable {
    private Map gameField;
    private Vector<Entity> entities;

    public ControlClass(){
        gameField = new Map(100, 100);
    }

    public Map getMap() {
        return gameField;
    }

    public Vector<Entity> getEntities() {
        return entities;
    }
}
