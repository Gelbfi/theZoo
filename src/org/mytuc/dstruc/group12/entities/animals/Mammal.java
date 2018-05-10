package org.mytuc.dstruc.group12.entities.animals;

import java.util.HashMap;

public abstract class Mammal extends Animal {
    private static HashMap<Integer,iAnimal> allAnimalsAvailable = new HashMap<>();
    private static Integer nextIncrementer = 0;
    private int myIdentifier;
    Mammal(String name, AnimalDangerType dangerousness, AnimalSpaceType spaceRequirements, AnimalHabitType requirement) {
        super(name, dangerousness, spaceRequirements, requirement);
        nextIncrementer++;
        allAnimalsAvailable.put(nextIncrementer, this);
        myIdentifier = nextIncrementer;
    }
    public static HashMap<Integer,iAnimal> getListOfAllAnimals(){
        return allAnimalsAvailable;
    }
    public void removeMe(){
        allAnimalsAvailable.remove( myIdentifier );
    }
}
