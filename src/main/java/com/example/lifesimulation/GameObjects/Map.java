package com.example.lifesimulation.GameObjects;

import java.io.Serializable;

public class Map implements Serializable {
    private final Integer temperature;
    private final Integer height;
    private final Integer width;

    public Map(int x, int y) {
        temperature = 30;
        height = x;
        width = y;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getTemperature() {
        return temperature;
    }

}
