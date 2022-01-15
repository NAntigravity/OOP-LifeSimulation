package com.example.lifesimulation.Game.Animals;

public class HumanFemale extends Human {
    public HumanFemale() {
        super();
        entityType = HumanFemale.class;
        hp = 100;
        foodSearchArea = 4;
        sex = Sex.female;
    }
}
