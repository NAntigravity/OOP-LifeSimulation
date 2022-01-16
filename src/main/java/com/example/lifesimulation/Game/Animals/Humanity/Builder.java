package com.example.lifesimulation.Game.Animals.Humanity;

import com.example.lifesimulation.Game.Buildings.House;
import com.example.lifesimulation.Game.Buildings.Village;
import com.example.lifesimulation.Game.Coordinate;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import org.jetbrains.annotations.NotNull;

public class Builder extends LazyHuman {
    private final int villageSearchRadius;

    public Builder() {
        villageSearchRadius = 10;
    }

    @Override
    public void work(Human human, EntityControlService entityControlService, Map map) {
        super.work(human, entityControlService, map);
        var randValue = Math.random();
        if (randValue < 0.01) {
            buildHouse(entityControlService, map, human);
        }
    }
    private @NotNull Coordinate searchForNearestHouse(@NotNull EntityControlService entityControlService, int x, int y,
                                                      int searchRadius, Map map, Human human) {
        var allEntities = entityControlService.getEntities();
        for (var entity : allEntities) {
            if (entity.getEntityType() == House.class) {
                var distance = Math.sqrt(Math.pow(x - entity.getX(), 2) + Math.pow(y - entity.getY(), 2));
                if (distance <= searchRadius) {
                    var nearestCoord = entityControlService.findNearestEmptyCoordinate(entity.getX(), entity.getY(), map, human.getSuitableTile());
                    return nearestCoord == null ? new Coordinate(x,y) : nearestCoord;
                }
            }
        }
        return new Coordinate(x, y);
    }

    public void buildHouse(@NotNull EntityControlService entityControlService, Map map, Human human) {
        var allEntities = entityControlService.getEntities();
        for (var entity : allEntities) {
            if (entity.getEntityType() == House.class) {
                var distance = Math.sqrt(Math.pow(human.getX() - entity.getX(), 2) + Math.pow(human.getY() - entity.getY(), 2));
                if (distance <= villageSearchRadius) {
                    var houseCoordinate = searchForNearestHouse(entityControlService, human.getX(), human.getY(), villageSearchRadius, map, human);
                    var house = new House(houseCoordinate.x, houseCoordinate.y);
                    house.setVillage(((House) entity).getVillage());
                    entityControlService.spawnEntityOnCoordinates(house, human.getX(), human.getY());
                    human.setHouse(house);
                    return;
                }
            }
        }
        var house = new House(human.getX(), human.getY());
        house.setVillage(new Village());
        entityControlService.spawnEntityOnCoordinates(house, human.getX(), human.getY());
        human.setHouse(house);
    }
}
