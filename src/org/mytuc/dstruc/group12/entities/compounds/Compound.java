package org.mytuc.dstruc.group12.entities.compounds;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.helper.ArrayHelper;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Compound {
    private Animal[] animals;
    private String name;

    private Animal.AnimalSpaceType space;
    private Animal.AnimalHabitType habit;

    public abstract boolean addAnimal(Animal animal);

    Compound(String compoundName,Animal.AnimalSpaceType space, Animal.AnimalHabitType habit){
        this.emptyCompound();
        this.name = compoundName;

        this.space = space;
        this.habit = habit;
    }
    void emptyCompound(){
        animals = new Animal[10];
    }
    public String getName(){
        return name;
    }
    Animal.AnimalDangerType getAnimalDangerousLevel(){
        ArrayList<Animal> list = getAnimals();
        if(list.size() < 1)
            return Animal.AnimalDangerType.HARMLESS;
        else
            return list.get( 0 ).getDangerousness();
    }
    public ArrayList<Animal> getAnimals(){
        ArrayList<Animal> list = new ArrayList<>();
        for(Animal animal : animals)
            if(animal != null)
                list.add( animal );
        return list;
    }
    boolean addToCompound(Animal animal){
        if(this.hasAnimalsIn() && animal.getDangerousness() != this.getAnimalDangerousLevel()){
            if(animal.getDangerousness() == Animal.AnimalDangerType.AGGRESSIV)
                emptyCompound();
            else
                return false;
        }

        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.animals));
        if(index > -1) {
            this.animals[index] = animal;
            animal.setCompound( this );
        }
        return index > -1;
    }

    public void removeAnimal(Animal animal) {
        for(int i = 0; i < animals.length; i++){
            if(animals[i] == null)
                continue;
            if(animals[i].equals( animal )){
                animals[i] = null;
            }
        }
    }

    boolean hasAnimalsIn() {
        for(Animal animal : animals)
            if(animal != null)
                return true;
        return false;
    }
}
