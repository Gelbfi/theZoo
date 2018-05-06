package org.mytuc.dstruc.group12.entities.animals;

import org.mytuc.dstruc.group12.entities.compounds.Compound;

import java.util.HashMap;

public abstract class Animal implements iAnimal {
    private String name;
    private AnimalDangerType dangerousness;
    private AnimalSpaceType spaceRequirements;
    private AnimalHabitType requirement;
    private Compound compoundLivingIn;

    public Animal(String name, AnimalDangerType dangerousness, AnimalSpaceType spaceRequirements, AnimalHabitType requirement){
        this.name = name;
        this.dangerousness = dangerousness;
        this.spaceRequirements = spaceRequirements;
        this.requirement = requirement;
    }
    public AnimalDangerType getDangerousness(){
        return dangerousness;
    }
    public String getName() {
        return name;
    }
    public void moveTo(Compound compound){
        if(this.compoundLivingIn != null){
            this.compoundLivingIn.removeAnimal( this );
        }
        this.compoundLivingIn = compound;
        compound.addAnimal( this );
    }

    public void setCompound(Compound compound) {
        this.compoundLivingIn = compound;
    }

    public enum AnimalDangerType {
        HARMLESS, AGGRESSIV
    }
    public AnimalSpaceType getSpaceRequirements(){
        return spaceRequirements;
    }
    public enum AnimalSpaceType {
        MIN, MAX
    }
    public AnimalHabitType getRequirement(){
        return requirement;
    }
    public enum AnimalHabitType {
        WATERWARM, WATERCOLD, RANGE, CAGE
    }
}
