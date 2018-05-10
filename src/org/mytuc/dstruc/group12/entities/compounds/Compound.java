package org.mytuc.dstruc.group12.entities.compounds;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.trade.Zoo;
import org.mytuc.dstruc.group12.helper.ArrayHelper;
import org.mytuc.dstruc.group12.helper.DEBUG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Compound {
    private Animal[] animals;
    private String name;
    private Zoo myZoo;

    private Animal.AnimalSpaceType space;
    Animal.AnimalHabitType habit;

    public abstract boolean addAnimal(Animal animal);

    Compound(String compoundName,Animal.AnimalSpaceType space, Animal.AnimalHabitType habit, Zoo myZoo){
        this.animals = new Animal[10];
        this.name = compoundName;
        this.myZoo = myZoo;

        this.space = space;
        this.habit = habit;
    }
    private void emptyCompound(){
        for(Animal a : this.animals){
            if(a != null) {
                DEBUG.log(a.getName()+" died");
                a.removeMe();
            }
        }
        animals = new Animal[10];
    }
    public String getName(){
        return name;
    }
    private Animal.AnimalDangerType getAnimalDangerousLevel(){
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
        if(animal.getSpaceRequirements() == Animal.AnimalSpaceType.MAX && this.space == Animal.AnimalSpaceType.MIN){
            DEBUG.log(animal.getName()+" died by immobility");
            animal.removeMe();
            return false;
        }
        if(this.hasAnimalsIn() && animal.getDangerousness() != this.getAnimalDangerousLevel()){
            if(animal.getDangerousness() == Animal.AnimalDangerType.AGGRESSIV) {
                emptyCompound();
                DEBUG.log(animal.getName()+" is very aggressive and is now alone in this compound");
            } else {
                DEBUG.log(animal.getName()+" was eaten while moving in");
                animal.removeMe();
                return false;
            }
        }

        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.animals));
        if(index > -1) {
            this.animals[index] = animal;
            animal.setCompound( this );
            animal.moveToZoo( myZoo );
        }
        return index > -1;
    }

    public void removeAnimal(Animal animal) {
        for(int i = 0; i < animals.length; i++){
            if(animals[i] == null)
                continue;
            if(animals[i] == animal ){
                this.myZoo.removeAnimal(animal);
                animals[i] = null;
            }
        }
    }

    private boolean hasAnimalsIn() {
        for(Animal animal : animals)
            if(animal != null)
                return true;
        return false;
    }

    public Zoo getZoo() {
        return this.myZoo;
    }

    public String getIdentifier() {
        return this.name.substring(0,4).toUpperCase();
    }

    abstract public boolean isAnimalClassCompatible(Class careFor);
}
