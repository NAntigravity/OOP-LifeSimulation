package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import com.example.lifesimulation.Game.Tiles.Tile;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity {
    protected Vector<Class> eatableEntities;
    protected Integer hunger;
    protected Integer foodSearchArea;
    protected Integer speed;
    protected Integer reproductionTime;
    protected Sex sex;

    public Animal() {
        super();
        entityType = Animal.class;
        eatableEntities = new Vector<>(List.of(Animal.class));
        hp = 0;
    }

    @Override
    public void live(Map map, EntityControlService entityControlService) {
        if(isDead) {
            return;
        }
        moveToRandomDirection(map);
        eat(entityControlService);
    }

    protected void eat(@NotNull EntityControlService entityControlService){
        var allEntity = entityControlService.getEntities();
        boolean isFound = false;
        synchronized (allEntity) {
            for (var entity : allEntity) {
                for (var eatableEntity : eatableEntities) {
                    if(eatableEntity.isAssignableFrom(entity.getEntityType())) {
                        entityControlService.killEntity(entity);
                        isFound = true;
                        break;
                    }
                }
                if(isFound) {
                    break;
                }
            }
        }
    }

    protected void moveToRandomDirection(Map map) {
        int direction = ThreadLocalRandom.current().nextInt(1, 5);
        int tempX = x;
        int tempY = y;

        switch (direction) {
            case 1:
                tempX += 1;
                break;
            case 2:
                tempX -= 1;
                break;
            case 3:
                tempY += 1;
                break;
            case 4:
                tempY -= 1;
                break;
        }

        if (tempX >= 0 && tempX < map.getWidth()
                && tempY >= 0 && tempY < map.getHeight()) {
            var isMovingAvailable = false;
            for (var tile : map.getTileTypes(tempX,tempY)) {
                if (suitableTile.contains(tile)) {
                   isMovingAvailable = true;
                   break;
                }
            }
            if(isMovingAvailable) {
                x = tempX;
                y = tempY;
            }
        }
    }
}