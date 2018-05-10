package org.mytuc.dstruc.group12.entities.compounds;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.Bird;
import org.mytuc.dstruc.group12.entities.trade.Zoo;
import org.mytuc.dstruc.group12.helper.DEBUG;

public class BirdCage extends Compound {
    public BirdCage(Zoo myZoo, String compoundName, Animal.AnimalSpaceType space, Animal.AnimalHabitType habit) {
        super(compoundName, space, habit, myZoo);
    }
    @Override
    public boolean isAnimalClassCompatible(Class careFor) {
        return Bird.class == careFor;
    }
    @Override
    public boolean addAnimal(Animal animal) {
        if(!(animal instanceof Bird)) {
            DEBUG.log(animal.getName()+" was bothered by the birds and died");
            animal.removeMe();
            return false;
        }

        if(animal.getRequirement() == Animal.AnimalHabitType.CAGE &&
            this.habit != Animal.AnimalHabitType.CAGE){
            DEBUG.log(animal.getName()+" flew away and was never seen again");
            animal.removeMe();
            return false;
        }

        return this.addToCompound( animal );
    }
}
