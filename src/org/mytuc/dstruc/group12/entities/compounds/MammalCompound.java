package org.mytuc.dstruc.group12.entities.compounds;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.Mammal;

public class MammalCompound extends Compound {
    public MammalCompound(String compoundName, Animal.AnimalSpaceType space, Animal.AnimalHabitType habit) {
        super(compoundName, space, habit);
    }

    @Override
    public boolean addAnimal(Animal animal) {
        if(!(animal instanceof Mammal))
            return false;

        return this.addToCompound( animal );
    }
}
