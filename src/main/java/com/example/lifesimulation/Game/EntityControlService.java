package com.example.lifesimulation.Game;

import com.example.lifesimulation.Game.Animals.Animal;
import com.example.lifesimulation.Game.Animals.Sex;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class EntityControlService {
    private final Vector<Entity> entities = new Vector<>();
    private final Map gameField;
    private Vector<Entity> entitiesToCreate = new Vector<>();

    public EntityControlService(Map map) {
        gameField = map;
    }

    public Vector<Entity> getEntities() {
        return entities;
    }

    public void spawnEntityOnCoordinates(@NotNull Entity entity, int x, int y) {
        entity.setX(x);
        entity.setY(y);
        entitiesToCreate.add(entity);
    }

    public void spawnEntityOnRandomCoordinates(Entity entity, Map map) {
        boolean flag = false;
        while (!flag) {
            int x = ThreadLocalRandom.current().nextInt(0, gameField.getWidth());
            int y = ThreadLocalRandom.current().nextInt(0, gameField.getHeight());
            flag = trySetupCoordinates(entity, map, x, y);
        }
    }

    private boolean trySetupCoordinates(Entity entity, Map map, int x, int y) {
        boolean overlap = isOverlapByAnotherEntity(x, y);
        boolean isSpawnAvailable = isSpawnAvailableByTileType(entity, map, x, y);
        if (!overlap && isSpawnAvailable) {
            spawnEntityOnCoordinates(entity, x, y);
            return true;
        }
        return false;
    }

    private boolean isOverlapByAnotherEntity(int x, int y) {
        for (Entity e : entities) {
            if (x == e.getX() && y == e.getY()) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpawnAvailableByTileType(Entity entity, @NotNull Map map, int x, int y) {
        for (var tile : map.getTileTypes(x, y)) {
            if (entity.suitableTile.contains(tile)) {
                return true;
            }
        }
        return false;
    }

    public void killEntity(@NotNull Entity entity) {
        entity.isDead = true;
    }

    public void clearKilledEntities() {
        var entitySize = entities.size();
        for (int i = 0; i < entitySize; i++) {
            if (entities.get(i).isDead) {
                entities.remove(entities.get(i));
                i--;
                entitySize--;
            }
        }
    }

    public void appendExistingEntityCollection() {
        entities.addAll(entitiesToCreate);
        entitiesToCreate = new Vector<>();
    }

    public boolean isAnyEntityOnCoordinate(Coordinate coordinate) {
        for (var entity : entities) {
            if (Objects.equals(entity.getX(), coordinate.x) && Objects.equals(entity.getY(), coordinate.y)) {
                return true;
            }
        }
        return false;
    }

    public Coordinate findNearestEmptyCoordinate(int x, int y, Map map, Vector<Class> availableTiles) {
        if (!isAnyEntityOnCoordinate(new Coordinate(x - 1, y - 1))) {
            for (var tile : availableTiles) {
                if (x - 1 < 0 || y - 1 < 0) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x - 1, y - 1))) {
                    return new Coordinate(x - 1, y - 1);
                }
            }
        } else if (!isAnyEntityOnCoordinate(new Coordinate(x - 1, y))) {
            for (var tile : availableTiles) {
                if (x - 1 < 0) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x - 1, y))) {
                    return new Coordinate(x - 1, y);
                }
            }
        } else if (!isAnyEntityOnCoordinate(new Coordinate(x - 1, y + 1))) {
            for (var tile : availableTiles) {
                if (x - 1 < 0 || y + 1 > map.getHeight()) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x - 1, y + 1))) {
                    return new Coordinate(x - 1, y + 1);
                }
            }
        } else if (!isAnyEntityOnCoordinate(new Coordinate(x, y + 1))) {
            for (var tile : availableTiles) {
                if (y + 1 > map.getHeight()) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x, y + 1))) {
                    return new Coordinate(x, y + 1);
                }
            }
        } else if (!isAnyEntityOnCoordinate(new Coordinate(x + 1, y + 1))) {
            for (var tile : availableTiles) {
                if (x + 1 > map.getWidth() || y + 1 > map.getHeight()) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x + 1, y + 1))) {
                    return new Coordinate(x + 1, y + 1);
                }
            }
        } else if (!isAnyEntityOnCoordinate(new Coordinate(x + 1, y))) {
            for (var tile : availableTiles) {
                if (x + 1 > map.getWidth()) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x + 1, y))) {
                    return new Coordinate(x + 1, y);
                }
            }
        } else if (!isAnyEntityOnCoordinate(new Coordinate(x + 1, y - 1))) {
            for (var tile : availableTiles) {
                if (x + 1 > map.getWidth() || y - 1 < 0) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x + 1, y - 1))) {
                    return new Coordinate(x + 1, y - 1);
                }
            }
        } else if (!isAnyEntityOnCoordinate(new Coordinate(x, y - 1))) {
            for (var tile : availableTiles) {
                if (y - 1 < 0) {
                    return null;
                }
                if (map.IsTileTypeEqual(tile, map.getTileTypes(x, y - 1))) {
                    return new Coordinate(x, y - 1);
                }
            }
        }
        return findNearestEmptyCoordinate(x - 1, y - 1, map, availableTiles);
    }

    public Entity getEntityByCoordinate(int x, int y) {
        for (var entity : entities) {
            if (entity.getX() == x && entity.getY() == y) {
                return entity;
            }
        }
        return null;
    }

    public Entity findNearestEntityOfType(Class entityType, int x, int y) {
        var entityList = getEntitiesByType(entityType);
        var resultEntity = entityList.stream().min((o1, o2) -> {
            var distance1 = Math.sqrt(Math.pow(o1.x - x, 2) + Math.pow(o1.y - y, 2));
            var distance2 = Math.sqrt(Math.pow(x - o2.x, 2) + Math.pow(y - o2.y, 2));
            if (distance1 > distance2) {
                return 1;
            } else if (Math.abs(distance1 - distance2) < 0.0000001) {
                return 0;
            } else {
                return -1;
            }
        });
        return resultEntity.get();
    }

    public Entity findNearestAnimalOfOppositeSexByType(Class entityType, Sex sex, int x, int y) {
        if (!Animal.class.isAssignableFrom(entityType)) {
            return null;
        }
        var entityList = getEntitiesByType(entityType);
        var resultEntity = entityList.stream().filter(e -> ((Animal) e).getSex() != sex).min((o1, o2) -> {
            var distance1 = Math.sqrt(Math.pow(o1.x - x, 2) + Math.pow(o1.y - y, 2));
            var distance2 = Math.sqrt(Math.pow(x - o2.x, 2) + Math.pow(y - o2.y, 2));
            if (distance1 > distance2) {
                return 1;
            } else if (Math.abs(distance1 - distance2) < 0.0000001) {
                return 0;
            } else {
                return -1;
            }
        });
        return resultEntity.orElse(null);
    }

    public Vector<Entity> getEntitiesByType(Class entityType) {
        var entityList = new Vector<Entity>();
        for (var entity : entities) {
            if (entity.getEntityType() == entityType) {
                entityList.add(entity);
            }
        }
        return entityList;
    }
}
