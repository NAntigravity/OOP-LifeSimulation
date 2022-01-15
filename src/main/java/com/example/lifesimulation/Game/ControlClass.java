package com.example.lifesimulation.Game;

import com.example.lifesimulation.Game.Animals.Pufferfish;
import com.example.lifesimulation.Game.Animals.Ship;
import com.example.lifesimulation.Game.Animals.Turtle;
import com.example.lifesimulation.Game.Nature.Grass;
import com.example.lifesimulation.Game.Nature.WaterLily;

import java.io.Serializable;
import java.util.List;
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
            var entityNameCollection = new Vector<>(List.of(
                    Turtle.class,
                    Ship.class,
                    Pufferfish.class,
                    Grass.class,
                    WaterLily.class
            ));
            int spawnEntityNumber = (int) (Math.random() * entityNameCollection.size());
            try {
                Entity entityToSpawn = entityNameCollection.get(spawnEntityNumber).newInstance();
                entityControlService.spawnEntity(entityToSpawn, gameField);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
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
