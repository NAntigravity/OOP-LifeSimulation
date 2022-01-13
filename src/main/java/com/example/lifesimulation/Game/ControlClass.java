package com.example.lifesimulation.Game;

import com.example.lifesimulation.Game.Animals.Ship;
import com.example.lifesimulation.Game.Animals.Turtle;

import java.io.Serializable;
import java.util.Vector;

public class ControlClass implements Serializable {
    private static ControlClass INSTANCE;
    private final Map gameField;
    private final EntityControlService entityControlService;

    private ControlClass() {
        gameField = new Map(100, 100);
        entityControlService = new EntityControlService(gameField);
        run();
    }

    public static ControlClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ControlClass();
        }
        return INSTANCE;
    }

    public Map getMap() {
        return gameField;
    }

    public Vector<Entity> getEntities() {
        return entityControlService.getEntities();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            double flip = Math.random();
            if (flip < 0.3) {
                Turtle turtle = new Turtle();
                entityControlService.spawnEntity(turtle);
            } else if (flip < 0.43) {
                Ship ship = new Ship();
                entityControlService.spawnEntity(ship);
            };
        }
    }

    public void LiveOneTick() {
        var entities = entityControlService.getEntities();
        synchronized (entities) {
            for (Entity entity : entities) {
                entity.live(gameField, entityControlService);
            }
            entityControlService.clearKilledEntities();
        }
    }

}
