package com.example.lifesimulation.GameObjects;

import java.io.Serializable;

public class ControlClass implements Serializable {
    private Map gameField;

    public ControlClass(){
        gameField = new Map(500, 500);
    }

    public Map getMap() {
        return gameField;
    }
}
