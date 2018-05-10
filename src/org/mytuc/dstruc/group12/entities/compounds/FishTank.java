package org.mytuc.dstruc.group12.entities.compounds;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.WaterAnimal;
import org.mytuc.dstruc.group12.entities.trade.Zoo;
import org.mytuc.dstruc.group12.helper.DEBUG;

public class FishTank extends Compound {
    public FishTank(Zoo myZoo, String compoundName, Animal.AnimalSpaceType space, Animal.AnimalHabitType habit) {
        super(compoundName, space, habit, myZoo);
    }
    @Override
    public boolean isAnimalClassCompatible(Class careFor) {
        return WaterAnimal.class == careFor;
    }
    @Override
    public boolean addAnimal(Animal animal) {
        if(!(animal instanceof WaterAnimal)) {
            DEBUG.log(animal.getName()+" has been drown");
            animal.removeMe();
            return false;
        }

        switch(animal.getRequirement()){
            case WATERWARM:
                if(this.habit != Animal.AnimalHabitType.WATERWARM){
                    DEBUG.log(animal.getName()+" has been frozen to death");
                    animal.removeMe();
                    return false;
                }
                break;
            case WATERCOLD:
                if(this.habit != Animal.AnimalHabitType.WATERCOLD){
                    DEBUG.log(animal.getName()+" has been frightened to death by warm water");
                    animal.removeMe();
                    return false;
                }
                break;
        }

        return this.addToCompound( animal );
    }
}
