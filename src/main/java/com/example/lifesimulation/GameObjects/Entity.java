package com.example.lifesimulation.GameObjects;

import java.io.Serializable;
import java.util.Vector;

public abstract class Entity implements Serializable {
    protected Class entityType;
    protected Integer hp;
    protected Integer x;
    protected Integer y;

    public Entity() {
        entityType = Entity.class;
        hp = 0;
    }

    public Integer getHp() {
        return hp;
    }

    public Class getEntityType() {
        return entityType;
    }

    public void live(Map map, Vector<Entity> entities) {
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
