package com.example.lifesimulation.Game;

import com.example.lifesimulation.Game.Animals.*;
import com.example.lifesimulation.Game.Animals.Humanity.HumanAdult;
import com.example.lifesimulation.Game.Animals.Humanity.HumanFemale;
import com.example.lifesimulation.Game.Animals.Humanity.HumanMale;
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
                    WaterLily.class,
                    Wolf.class,
                    HumanMale.class,
                    HumanFemale.class

            ));
            int spawnEntityNumber = (int) (Math.random() * entityNameCollection.size());
            try {
                if (spawnEntityNumber == 6) {
                    Entity entityToSpawn = new HumanMale(new HumanAdult());
                    entityControlService.spawnEntityOnRandomCoordinates(entityToSpawn, gameField);
                } else if (spawnEntityNumber == 7) {
                    Entity entityToSpawn = new HumanFemale(new HumanAdult());
                    entityControlService.spawnEntityOnRandomCoordinates(entityToSpawn, gameField);
                } else {
                    Entity entityToSpawn = entityNameCollection.get(spawnEntityNumber).newInstance();
                    entityControlService.spawnEntityOnRandomCoordinates(entityToSpawn, gameField);
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void liveOneTick() {
        var entities = entityControlService.getEntities();
        var randomValue = Math.random();
        synchronized (entities) {
            for (Entity entity : entities) {
                if (entity instanceof IViable) {
                    ((IViable) entity).live(gameField, entityControlService);
                }
            }
            entityControlService.clearKilledEntities();
            if (randomValue < 0.4) {
                addSomePlants();
            }
            entityControlService.appendExistingEntityCollection();
        }
    }

    private void addSomePlants() {
        var plantTypeList = new Vector<Class>(List.of(Grass.class, WaterLily.class));
        try {
            Entity entityToSpawn = (Entity) plantTypeList.get((int)(Math.random() * 2)).newInstance();
            entityControlService.spawnEntityOnRandomCoordinates(entityToSpawn, gameField);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
