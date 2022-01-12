package com.example.lifesimulation.Model;

import com.example.lifesimulation.Model.Animals.Ship;
import com.example.lifesimulation.Model.Animals.Turtle;

import java.io.Serializable;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class ControlClass implements Serializable {
    private static ControlClass INSTANCE;
    private final Map gameField;
    private final Vector<Entity> entities;

    private ControlClass() {
        gameField = new Map(100, 100);
        entities = new Vector<>();
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
        return entities;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            spawnRandomUnit();
        }
    }

    public void LiveOneTick() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).live(gameField, entities);
        }
    }

    private void spawnRandomUnit() {
        double flip = Math.random();
        if (flip < 0.3) {
            Turtle turtle = new Turtle();
            giveCoordinates(turtle);
            entities.add(turtle);
        } else if (flip < 0.43) {
            Ship ship = new Ship();
            giveCoordinates(ship);
            entities.add(ship);
        }
    }

    private void giveCoordinates(Entity entity) {
        boolean flag = true;
        while (flag) {
            int x = ThreadLocalRandom.current().nextInt(0, gameField.getWidth());
            int y = ThreadLocalRandom.current().nextInt(0, gameField.getHeight());

            boolean overlap = false;
            for (Entity e : entities) {
                if (x == e.getX() && y == e.getY()) {
                    overlap = true;
                    break;
                }
            }

            if (!overlap) {
                entity.setX(x);
                entity.setY(y);
                flag = false;
            }
        }
    }

}
