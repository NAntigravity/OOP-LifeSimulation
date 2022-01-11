package com.example.lifesimulation.GameObjects.Animals;

import com.example.lifesimulation.GameObjects.Entity;
import com.example.lifesimulation.GameObjects.Map;
import com.example.lifesimulation.GameObjects.SeasonDependent;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity implements SeasonDependent {
    //protected TreeSet<Entity> eatableEntities;

    public Animal() {
        super();
        entityType = Animal.class;
        //eatableEntities = new TreeSet<>(List.of(this));
    }

    public void live(Map map, Vector<Entity> entities) {
        moveToRandomDirection(map);
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
                x = tempX;
                y = tempY;
        }
    }
}
