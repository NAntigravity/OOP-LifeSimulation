package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import com.example.lifesimulation.Game.Nature.Plant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity implements IViable {
    protected Vector<Class> eatableEntities;
    protected Integer hunger;
    protected Integer foodSearchArea;
    protected Integer reproductionTime;
    public Integer reproductionCooldown;
    protected Sex sex;
    protected Integer foodSearchThreshold;
    @JsonIgnore
    protected Entity target;

    public Animal() {
        super();
        entityType = Animal.class;
        eatableEntities = new Vector<>(List.of(Plant.class, Animal.class));
        hp = 0;
        hunger = 100;
        target = null;
        foodSearchThreshold = 70;
        reproductionTime = 30;
        reproductionCooldown = reproductionTime;
        sex = Math.random() < 0.5 ? Sex.male : Sex.female;
    }

    public void live(Map map, EntityControlService entityControlService) {
        if (isDead) {
            return;
        }
        hunger--;
        if (hunger <= 0) {
            isDead = true;
            return;
        }
        if (target != null) {
            moveToTarget(map);
        } else {
            moveToRandomDirection(map);
        }
        reproduction(entityControlService);
        eat(entityControlService);
    }

    public void eat(@NotNull EntityControlService entityControlService) {
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
                            hunger += 10;
                            isFound = true;
                            target = null;
                            break;
                        }
                    }
                    if (isFound) {
                        break;
                    }
                }
            }
        }
        if (!isFound) {
            setTarget(entityControlService.findNearestEntityOfType(eatableEntities, x, y));
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

        move(map, tempX, tempY);
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public Entity getTarget() {
        return target;
    }

    protected void moveToTarget(Map map) {
        if (target == null) {
            return;
        }
        int targetX = target.getX();
        int targetY = target.getY();
        int tempX = x;
        int tempY = y;
        if (targetX > x) {
            tempX++;
        } else if (targetX < x) {
            tempX--;
        }
        if (targetY > y) {
            tempY++;
        } else if (targetY < y) {
            tempY--;
        }
        move(map, tempX, tempY);
    }

    private void move(Map map, int tempX, int tempY) {
        if (tempX >= 0 && tempX < map.getWidth()
                && tempY >= 0 && tempY < map.getHeight()) {
            var isMovingAvailable = false;
            for (var tile : map.getTileTypes(tempX, tempY)) {
                if (suitableTile.contains(tile)) {
                    isMovingAvailable = true;
                    break;
                }
            }
            if (isMovingAvailable) {
                x = tempX;
                y = tempY;
            }
        }
    }

    public void reproduction(@NotNull EntityControlService entityControlService) {
        if (reproductionCooldown > 0) {
            reproductionCooldown--;
            return;
        }
        var findEntity = entityControlService.findNearestAnimalOfOppositeSexByType(entityType, sex, x, y);
        if (findEntity == null) {
            return;
        }
        if (target == null) {
            setTarget(findEntity);
        }
        var distance = Math.sqrt(Math.pow(x - findEntity.getX(), 2) + Math.pow(y - findEntity.getY(), 2));
        if (distance < 2) {
            try {
                Entity newEntity = (Entity) entityType.newInstance();
                entityControlService.spawnEntityOnCoordinates(newEntity, x, y);
                this.updateReproductionCooldown();
                ((Animal) findEntity).updateReproductionCooldown();
                target = null;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateReproductionCooldown() {
        reproductionCooldown = reproductionTime;
    }

    public Sex getSex() {
        return sex;
    }
}
