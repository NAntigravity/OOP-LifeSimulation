package OOP.HITs.lifesimulation.Game.Animals.Humanity;

import OOP.HITs.lifesimulation.Game.Animals.Sex;
import OOP.HITs.lifesimulation.Game.EntityControlService;
import OOP.HITs.lifesimulation.Game.Map;

public class HumanFemale extends Human {
    public HumanFemale(IAge age) {
        super(age);
        entityType = HumanFemale.class;
        hp = 100;
        foodSearchArea = 4;
        sex = Sex.female;
        inventorySpace = 300;
    }

    public HumanFemale(IAge age, Human parentOne, Human parentTwo) {
        super(age, parentOne, parentTwo);
        entityType = HumanFemale.class;
        hp = 100;
        foodSearchArea = 4;
        sex = Sex.female;
        inventorySpace = 300;
    }

    @Override
    public void liveSpecificSexLife(Map map, EntityControlService entityControlService) {
        //Do nothing
    }
}
