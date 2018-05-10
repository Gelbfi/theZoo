package org.mytuc.dstruc.group12.entities.compounds;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.Mammal;
import org.mytuc.dstruc.group12.entities.trade.Zoo;
import org.mytuc.dstruc.group12.helper.DEBUG;

public class MammalCompound extends Compound {
    public MammalCompound(Zoo myZoo, String compoundName, Animal.AnimalSpaceType space, Animal.AnimalHabitType habit) {
        super(compoundName, space, habit, myZoo);
    }
    @Override
    public boolean isAnimalClassCompatible(Class careFor) {
        return Mammal.class == careFor;
    }
    @Override
    public boolean addAnimal(Animal animal) {
        if(!(animal instanceof Mammal)) {
            DEBUG.log(animal.getName()+" felt uncomfortable and died");
            animal.removeMe();
            return false;
        }
        if(
            (animal.getRequirement() == Animal.AnimalHabitType.CAGE ||
            animal.getRequirement() == Animal.AnimalHabitType.RANGE) &&
            (this.habit == Animal.AnimalHabitType.WATERCOLD ||
            this.habit == Animal.AnimalHabitType.WATERWARM)
        ){
            DEBUG.log(animal.getName()+" has been drown");
            animal.removeMe();
            return false;
        } else if(animal.getRequirement() == Animal.AnimalHabitType.CAGE &&
            this.habit == Animal.AnimalHabitType.RANGE){
            DEBUG.log(animal.getName()+" jumped over the fence and was never seen again");
            animal.removeMe();
            return false;
        }

        return this.addToCompound( animal );
    }
}
