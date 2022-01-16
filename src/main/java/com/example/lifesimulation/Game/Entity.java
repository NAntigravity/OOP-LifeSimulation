package com.example.lifesimulation.Game;

import com.example.lifesimulation.Game.Food.Food;
import com.example.lifesimulation.Game.Tiles.Tile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public abstract class Entity implements Serializable {
    protected Class entityType;
    protected Integer hp;
    protected Integer x;
    protected Integer y;
    public boolean isDead = false;
    protected Vector<Class> suitableTile;

    public Entity() {
        entityType = Entity.class;
        hp = 0;
        suitableTile = new Vector<>(List.of(Tile.class));
    }

    public Integer getHp() {
        return hp;
    }

    public Class getEntityType() {
        return entityType;
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

    public abstract Food getHarvest();

    public Vector<Class> getSuitableTile() {
        return suitableTile;
    }
}
