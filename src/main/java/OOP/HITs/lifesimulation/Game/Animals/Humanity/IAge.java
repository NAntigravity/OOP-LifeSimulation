package OOP.HITs.lifesimulation.Game.Animals.Humanity;

import OOP.HITs.lifesimulation.Game.EntityControlService;
import OOP.HITs.lifesimulation.Game.Map;

public interface IAge {
    void humanEat(Human human, EntityControlService entityControlService);
    void humanReproduction(Human human, EntityControlService entityControlService);
    void liveSpecificLife(Human human, Map map, EntityControlService entityControlService);
}
