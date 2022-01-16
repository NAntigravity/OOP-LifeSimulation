package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.Animals.Animal;
import com.example.lifesimulation.Game.Animals.Sex;
import com.example.lifesimulation.Game.Entity;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import org.jetbrains.annotations.NotNull;

public class HumanAdult implements IAge {
    public final Class AgeType = HumanAdult.class;

    @Override
    public void humanEat(@NotNull Human human, EntityControlService entityControlService) {
        if (human.getHunger() <= human.getFoodSearchThreshold()) {
            var allEntity = entityControlService.getEntities();
            boolean isFound = false;
            synchronized (allEntity) {
                for (var entity : allEntity) {
                    if (entity == human) {
                        continue;
                    }
                    var distance = Math.sqrt(Math.pow(human.getX() - entity.getX(), 2) + Math.pow(human.getY() - entity.getY(), 2));
                    if (human.getFoodSearchArea() != null && distance <= human.getFoodSearchArea()) {
                        for (var eatableEntity : human.getEatableEntities()) {
                            if (eatableEntity.getName().equals(this.getClass().getName())) {
                                continue;
                            }
                            if (eatableEntity.isAssignableFrom(entity.getEntityType())) {
                                human.addItemToInventory(entity.getHarvest());
                                entityControlService.killEntity(entity);
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
        if (human.getInventoryCount() == 0 && human.getHunger() < human.getFoodSearchThreshold() / 2) {
            human.eat(entityControlService);
        }
        if (human.getHunger() < human.getFoodSearchThreshold() / 2) {
            human.feedFromInventory(human);
        }
    }

    @Override
    public void humanReproduction(@NotNull Human human, EntityControlService entityControlService) {
        if (human.reproductionCooldown > 0) {
            human.reproductionCooldown--;
            return;
        }
        var humanGender = human.getSex();
        var findEntity = entityControlService.findNearestAnimalOfOppositeSexByType(humanGender == Sex.male ? HumanFemale.class : HumanMale.class,
                human.getSex(), human.getX(), human.getY());
        if (findEntity == null) {
            return;
        }
        if (human.getTarget() == null) {
            human.setTarget(findEntity);
        }
        var distance = Math.sqrt(Math.pow(human.getX() - findEntity.getX(), 2) + Math.pow(human.getY() - findEntity.getY(), 2));
        if (distance < 2) {
            Entity newEntity = Math.random() < 0.5 ? new HumanMale(new HumanChild()) : new HumanFemale(new HumanChild());
            entityControlService.spawnEntityOnCoordinates(newEntity, human.getX(), human.getY());
            human.updateReproductionCooldown();
            ((Animal) findEntity).updateReproductionCooldown();
        }
    }

    @Override
    public void liveSpecificLife(@NotNull Human human, Map map, EntityControlService entityControlService) {
        human.liveSpecificSexLife(map, entityControlService);
    }
}
