package com.example.lifesimulation.Game;

import com.example.lifesimulation.Game.Animals.Pufferfish;
import com.example.lifesimulation.Game.Animals.Ship;
import com.example.lifesimulation.Game.Animals.Turtle;
import com.example.lifesimulation.Game.Nature.Grass;
import com.example.lifesimulation.Game.Nature.WaterLily;

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
            var categoryCountNumber = 5;
            int spawnEntityNumber = (int) (Math.random() * categoryCountNumber);
            if (spawnEntityNumber == 0) {
                Turtle turtle = new Turtle();
                entityControlService.spawnEntity(turtle, gameField);
            }
            if (spawnEntityNumber == 1) {
                Ship ship = new Ship();
                entityControlService.spawnEntity(ship, gameField);
            }
            if (spawnEntityNumber == 2) {
                Pufferfish pufferfish = new Pufferfish();
                entityControlService.spawnEntity(pufferfish, gameField);
            }
            if (spawnEntityNumber == 3) {
                WaterLily waterLily = new WaterLily();
                entityControlService.spawnEntity(waterLily, gameField);
            }
            if (spawnEntityNumber == 4) {
                Grass grass = new Grass();
                entityControlService.spawnEntity(grass, gameField);
            }
        }
    }

    public void liveOneTick() {
        var entities = entityControlService.getEntities();
        synchronized (entities) {
            for (Entity entity : entities) {
                entity.live(gameField, entityControlService);
            }
            entityControlService.clearKilledEntities();
        }
    }

}
