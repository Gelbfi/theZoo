package org.mytuc.dstruc.group12.entities.trade;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.Mammal;
import org.mytuc.dstruc.group12.entities.animals.iAnimal;
import org.mytuc.dstruc.group12.entities.compounds.BirdCage;
import org.mytuc.dstruc.group12.entities.compounds.Compound;
import org.mytuc.dstruc.group12.entities.compounds.FishTank;
import org.mytuc.dstruc.group12.entities.compounds.MammalCompound;
import org.mytuc.dstruc.group12.entities.persons.Employee;
import org.mytuc.dstruc.group12.entities.persons.Visitor;
import org.mytuc.dstruc.group12.helper.ArrayHelper;
import org.mytuc.dstruc.group12.helper.DEBUG;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

public class Zoo {
    private Compound[] compounds;
    private Visitor[] visitors;
    private Employee[] employees;
    private ArrayList<iAnimal> animals;
    private String name;

    public Zoo(String theName){
        compounds = new Compound[10];
        visitors = new Visitor[20];
        employees = new Employee[20];
        name = theName;

        animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addCompoundMammal(String name, Animal.AnimalSpaceType spaceType, Animal.AnimalHabitType habitType) {
        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.compounds));
        if(index > -1){
            this.compounds[index] = new MammalCompound(this, name, spaceType, habitType);
        }
        return index > 1;
    }
    public boolean addCompoundBird(String name, Animal.AnimalSpaceType spaceType, Animal.AnimalHabitType habitType){
        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.compounds));
        if(index > -1){
            this.compounds[index] = new BirdCage(this, name, spaceType, habitType);
        }
        return index > 1;
    }
    public boolean addCompoundFish(String name, Animal.AnimalSpaceType spaceType, Animal.AnimalHabitType habitType){
        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.compounds));
        if(index > -1){
            this.compounds[index] = new FishTank(this, name, spaceType, habitType);
        }
        return index > 1;
    }
    public boolean hasCompoundWithID(String identifier){
        for(Compound c : this.compounds){
            if(c != null && c.getIdentifier().equals(identifier.toUpperCase()))
                return true;
        }
        return false;
    }
    public Compound getCompoundByID(String identifier){
        for(Compound c : this.compounds){
            if(c != null && c.getIdentifier().equals(identifier.toUpperCase()))
                return c;
        }
        return null;
    }
    public boolean addEmployee(Employee employee) {
        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.employees));
        if(index > -1) {
            this.employees[index] = employee;
            employee.setEmployer( this );
        }
        return index > 1;
    }

    public ArrayList<Compound> getCompounds() {
        ArrayList<Compound> list = new ArrayList<>();
        for(Compound compound : compounds)
            if(compound != null)
                list.add(compound);

        return list;
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<>();
        for(Employee employee : employees)
            if(employee != null)
                list.add(employee);

        return list;
    }

    public boolean addVisitor(Visitor visitor) {
        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.visitors));
        if(index > -1)
            this.visitors[index] = visitor;

        return index > 1;
    }

    public ArrayList<Visitor> getVisitors() {
        ArrayList<Visitor> list = new ArrayList<>();
        for(Visitor visitor : visitors)
            if(visitor != null)
                list.add(visitor);

        return list;
    }

    public void addAnimal(Animal animal) {
        this.animals.add( animal );
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }
    public int getAnimalCount(){
        this.animals.removeAll(Collections.singleton(null));
        return this.animals.size();
    }
    public ArrayList<iAnimal> getAllAnimals(){
        this.animals.removeAll(Collections.singleton(null));
        return this.animals;
    }

    public HashSet<iAnimal> getAnimalsByType(Class animalSubClass) {
        HashSet<iAnimal> map = new HashSet<>();
        for(iAnimal animal : this.animals){
            if(animal != null && animal.getClass().getSuperclass() == animalSubClass){
                map.add(animal);
            }
        }
        return map;
    }
}
