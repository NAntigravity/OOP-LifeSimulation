package OOP.HITs.lifesimulation.Game.Animals.Humanity;

import OOP.HITs.lifesimulation.Game.EntityControlService;
import OOP.HITs.lifesimulation.Game.Map;
import org.jetbrains.annotations.NotNull;

public class HumanChild implements IAge {
    public final Class AgeType = HumanChild.class;

    @Override
    public void humanEat(@NotNull Human human, EntityControlService entityControlService) {
        if (human.getHunger() < human.getFoodSearchThreshold()) {
            //Set parent as target
            if (human.getParentOne().getInventoryCount() != 0) {
                human.setTarget(human.getParentOne());
            } else {
                human.setTarget(human.getParentTwo());
            }

            var distanceToParentOne = Math.sqrt(Math.pow(human.getX() - human.getParentOne().getX(), 2)
                    + Math.pow(human.getY() - human.getParentOne().getY(), 2));
            if (distanceToParentOne < 2) {
                human.getParentOne().feedFromInventory(human);
            }

            var distanceToParentTwo = Math.sqrt(Math.pow(human.getX() - human.getParentTwo().getX(), 2)
                    + Math.pow(human.getY() - human.getParentTwo().getY(), 2));
            if (distanceToParentTwo < 2) {
                human.getParentTwo().feedFromInventory(human);
            }
        }
        human.hungerTick();
    }

    @Override
    public void humanReproduction(Human human, EntityControlService entityControlService) {
        //Do nothing
    }

    @Override
    public void liveSpecificLife(Human human, Map map, EntityControlService entityControlService) {
        //Do nothing
    }
}
