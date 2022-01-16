package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.Animals.Animal;
import com.example.lifesimulation.Game.Animals.Herbivore;
import com.example.lifesimulation.Game.Animals.Predator;
import com.example.lifesimulation.Game.Buildings.House;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Food.Food;
import com.example.lifesimulation.Game.Map;
import com.example.lifesimulation.Game.Nature.Plant;
import com.example.lifesimulation.Game.Tiles.Desert;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Vector;

public abstract class Human extends Animal {
    protected Human parentOne;
    protected Human parentTwo;
    protected House house;
    protected IAge age;
    protected Integer growingTime;
    protected IWork job;
    @JsonIgnore
    protected Vector<Food> inventory;
    @JsonIgnore
    protected Integer inventorySpace;

    public Human(IAge age) {
        super();
        entityType = Human.class;
        hp = 100;
        foodSearchArea = 4;
        suitableTile = new Vector<>(List.of(Desert.class));
        house = null;
        changeAge(age);
        reproductionTime = 10;
        reproductionCooldown = 10;
        growingTime = 30;
        hunger = 150;
        foodSearchThreshold = 100;
        inventorySpace = 0;
        inventory = new Vector<>();
        eatableEntities = new Vector<>(List.of(Predator.class, Herbivore.class, Plant.class));
    }

    public Human(IAge age, Human parentOne, Human parentTwo){
        this(age);
        this.parentOne = parentOne;
        this.parentTwo = parentTwo;
    }

    @Override
    public void live(Map map, EntityControlService entityControlService) {
        if (isDead) {
            return;
        }
        hungerTick();
        if (hunger <= 0) {
            isDead = true;
            return;
        }
        if (age.getClass() == HumanChild.class) {
            growingTime--;
            if (growingTime == 0) {
                changeAge(new HumanAdult());
            }
        }
        if (job != null) {
            job.work(this, entityControlService, map);
        }
        moveToRandomDirection(map);
        age.humanEat(this, entityControlService);
        age.humanReproduction(this, entityControlService);
        age.liveSpecificLife(this, map, entityControlService);
    }

    public House getHouse() {
        return house;
    }

    public IAge getHumanAge() {
        return age;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void changeAge(@NotNull IAge age) {
        this.age = age;
        if (age.getClass() == HumanAdult.class) {
            setJob(new Builder());
        }
    }

    public void addItemToInventory(Food food) {
        inventory.add(food);
    }

    public void feedFromInventory(@NotNull Human human) {
        human.feed(getInventoryCount() == 0 ? null : inventory.firstElement());
    }

    public abstract void liveSpecificSexLife(Map map, EntityControlService entityControlService);

    public void setJob(IWork job) {
        this.job = job;
    }

    public void feed(Food food) {
        if (food != null) {
            hunger += food.size;
        }
    }

    public Integer getInventoryCount(){
        return inventory.size();
    }

    public Human getParentOne() {
        return parentOne;
    }

    public Human getParentTwo() {
        return parentTwo;
    }
}
