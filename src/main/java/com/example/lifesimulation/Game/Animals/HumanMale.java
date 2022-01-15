package com.example.lifesimulation.Game.Animals;

import com.example.lifesimulation.Game.Buildings.House;
import com.example.lifesimulation.Game.Buildings.Village;
import com.example.lifesimulation.Game.Coordinate;
import com.example.lifesimulation.Game.EntityControlService;
import com.example.lifesimulation.Game.Map;
import org.jetbrains.annotations.NotNull;

public class HumanMale extends Human {
    private final int villageSearchRadius;

    public HumanMale() {
        super();
        entityType = HumanMale.class;
        hp = 100;
        foodSearchArea = 4;
        villageSearchRadius = 10;
        sex = Sex.male;
    }

    private @NotNull Coordinate searchForNearestHouse(@NotNull EntityControlService entityControlService, int x, int y,
                                                      int searchRadius, Map map) {
        var allEntities = entityControlService.getEntities();
        for (var entity : allEntities) {
            if (entity.getEntityType() == House.class) {
                var distance = Math.sqrt(Math.pow(x - entity.getX(), 2) + Math.pow(y - entity.getY(), 2));
                if (distance <= searchRadius) {
                    var nearestCoord = entityControlService.findNearestEmptyCoordinate(entity.getX(), entity.getY(), map, suitableTile);
                    return nearestCoord == null ? new Coordinate(x,y) : nearestCoord;
                }
            }
        }
        return new Coordinate(x, y);
    }

    public void buildHouse(@NotNull EntityControlService entityControlService, Map map) {
        var allEntities = entityControlService.getEntities();
        for (var entity : allEntities) {
            if (entity.getEntityType() == House.class) {
                var distance = Math.sqrt(Math.pow(x - entity.getX(), 2) + Math.pow(y - entity.getY(), 2));
                if (distance <= villageSearchRadius) {
                    var houseCoordinate = searchForNearestHouse(entityControlService, x, y, villageSearchRadius, map);
                    var house = new House(houseCoordinate.x, houseCoordinate.y);
                    house.setVillage(((House) entity).getVillage());
                    entityControlService.spawnEntityOnCoordinates(house, x, y);
                    setHouse(house);
                    return;
                }
            }
        }
        var house = new House(x, y);
        house.setVillage(new Village());
        entityControlService.spawnEntityOnCoordinates(house, x, y);
        setHouse(house);
    }

    @Override
    public void live(Map map, EntityControlService entityControlService) {
        var randValue = Math.random();
        if (randValue < 0.01) {
            buildHouse(entityControlService, map);
        }
        super.live(map, entityControlService);
    }
}
