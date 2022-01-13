package com.example.lifesimulation.Game;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class EntityControlService {
    private final Vector<Entity> entities = new Vector<>();
    private final Map gameField;

    public EntityControlService(Map map) {
        gameField = map;
    }
    public Vector<Entity> getEntities() {
        return entities;
    }

    public void spawnEntity(Entity entity) {
        giveCoordinates(entity);
        entities.add(entity);
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

    public void killEntity(Entity entity) {
        entity.isDead = true;
    }

    public void clearKilledEntities() {
        var entitySize = entities.size();
        for(int i = 0; i < entitySize; i++) {
            if(entities.get(i).isDead) {
                entities.remove(entities.get(i));
                i--;
                entitySize--;
            }
        }
    }
}
