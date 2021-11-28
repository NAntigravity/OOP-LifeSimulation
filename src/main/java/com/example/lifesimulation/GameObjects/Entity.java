package com.example.lifesimulation.GameObjects;

import java.io.Serializable;

public class Entity implements Serializable {
    protected Class entityType;
    protected Integer hp;

    public Entity() {
        entityType = Entity.class;
        hp = 0;
    }

    public Integer getHp(){
        return hp;
    }

    public Class getEntityType(){
        return entityType;
    }
}
