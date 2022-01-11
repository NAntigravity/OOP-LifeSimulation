package com.example.lifesimulation.GameObjects.Nature;

public class IceHerb extends Plant implements Healing {
    public IceHerb() {
        entityType = IceHerb.class;
        //suitableTile = new TreeSet<>(List.of(Snow.class, Ice.class));
    }
}
