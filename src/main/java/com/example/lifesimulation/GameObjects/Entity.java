package com.example.lifesimulation.GameObjects;

import java.io.Serializable;

public class Entity implements Serializable {
    protected EntityType entityType;

    public Entity() {
        entityType = EntityType.ENTITY;
    }
}
