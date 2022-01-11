package com.example.lifesimulation.ViewModel;

import com.example.lifesimulation.GameObjects.Entity;
import com.example.lifesimulation.GameObjects.Map;

import java.util.Vector;

public class InfoAboutGameViewModel {
    public Map map;
    public Vector<Entity> entities;
    public InfoAboutGameViewModel(Map map, Vector<Entity> entities) {
        this.map = map;
        this.entities = entities;
    }
}
