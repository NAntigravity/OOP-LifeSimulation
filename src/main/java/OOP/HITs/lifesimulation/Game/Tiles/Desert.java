package OOP.HITs.lifesimulation.Game.Tiles;

import java.util.Collections;

public class Desert extends SolidTile {
    public Desert() {
        super();
        tileType = Collections.singleton(Desert.class);
    }
}