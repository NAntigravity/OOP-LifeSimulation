package OOP.HITs.lifesimulation.Game;

import OOP.HITs.lifesimulation.Game.Tiles.Desert;
import OOP.HITs.lifesimulation.Game.Tiles.LiquidTile;
import OOP.HITs.lifesimulation.Game.Tiles.SolidTile;
import OOP.HITs.lifesimulation.Game.Tiles.Tile;
import OOP.HITs.lifesimulation.Game.Tiles.Water;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Set;
import java.util.Vector;

public class Map implements Serializable {
    private final Integer temperature;
    private final Integer height;
    private final Integer width;
    private Vector<Vector<Tile>> tiles;

    public Map(int x, int y) {
        temperature = 30;
        height = y;
        width = x;
        generateMap();
    }

    private void generateMap() {
        tiles = new Vector<>();
        for (int i = 0; i < width; i++) {
            Vector<Tile> r = new Vector<>();
            int counter = 0;
            int random = 24 + (int) (Math.random() * 3);
            for (int j = 0; j < height; j++) {
                int a = (int) (Math.random() * 3);
                if (a == 1 || a == 0 || a == 2) {
                    SolidTile desert = new SolidTile();
                    desert.setTileType(Desert.class);
                    r.add(desert);
                }
                if (a == 0) {
                    LiquidTile water = new LiquidTile();
                    water.setTileType(Water.class);
                    while (counter != random) {
                        r.add(0, water);
                        counter++;
                    }
                }
            }
            tiles.add(r);
        }
    }

    public Vector<Vector<Tile>> getTiles() {
        return tiles;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Set<Class> getTileTypes(int x, int y) {
        return tiles.get(y).get(x).getTileType();
    }

    public boolean IsTileTypeEqual(Class tileClass, @NotNull Set<Class> currentTileClasses) {
        for (var tile : currentTileClasses) {
            if(tileClass.isAssignableFrom(tile)) {
                return true;
            }
        }
        return false;
    }
}
