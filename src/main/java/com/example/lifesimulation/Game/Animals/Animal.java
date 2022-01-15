package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import com.example.lifesimulation.Game.Nature.Plant;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity implements IsViable {
    protected Vector<Class> eatableEntities;
    protected Integer hunger;
    protected Integer foodSearchArea;
    protected Integer speed;
    protected Integer reproductionTime;
    protected Sex sex;
    protected Integer foodSearchThreshold;

    public Animal() {
        super();
        entityType = Animal.class;
        eatableEntities = new Vector<>(List.of(Plant.class, Animal.class));
        hp = 0;
        hunger = 100;
        foodSearchThreshold = 70;
    }

    public void live(Map map, EntityControlService entityControlService) {
        if(isDead) {
            return;
        }
        hunger--;
        if(hunger <= 0) {
            isDead = true;
            return;
        }
        moveToRandomDirection(map);
        eat(entityControlService);
    }

    protected void eat(@NotNull EntityControlService entityControlService){
        if (hunger >= foodSearchThreshold) {
            return;
        }
        var allEntity = entityControlService.getEntities();
        boolean isFound = false;
        synchronized (allEntity) {
            for (var entity : allEntity) {
                if (entity == this) {
                    continue;
                }
                var distance = Math.sqrt(Math.pow(x - entity.getX(), 2) + Math.pow(y - entity.getY(), 2));
                if (foodSearchArea != null && distance <= foodSearchArea) {
                    for (var eatableEntity : eatableEntities) {
                        if (eatableEntity.getName().equals(this.getClass().getName())) {
                            continue;
                        }
                        if (eatableEntity.isAssignableFrom(entity.getEntityType())) {
                            entityControlService.killEntity(entity);
                            hunger+=10;
                            isFound = true;
                            break;
                        }
                    }
                    if (isFound) {
                        break;
                    }
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
