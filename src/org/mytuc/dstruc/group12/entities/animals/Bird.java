package org.mytuc.dstruc.group12.entities.animals;

import java.util.HashMap;

public abstract class Bird extends Animal {
    private static HashMap<Integer,iAnimal> allAnimalsAvailable;
    private static Integer nextIncrementer = 0;
    Bird(String name, AnimalDangerType dangerousness, AnimalSpaceType spaceRequirements, AnimalHabitType requirement) {
        super(name, dangerousness, spaceRequirements, requirement);
        allAnimalsAvailable = new HashMap<>();
        nextIncrementer++;
        allAnimalsAvailable.put(nextIncrementer, this);
    }
    public static HashMap<Integer,iAnimal> getListOfAllAnimals(){
        return allAnimalsAvailable;
    }
}
