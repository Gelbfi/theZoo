package org.mytuc.dstruc.group12.entities.persons;

import org.mytuc.dstruc.group12.entities.animals.iAnimal;
import org.mytuc.dstruc.group12.entities.compounds.Compound;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Employee extends Person {
    private Class careFor;
    private Zoo employer;
    public Employee(String name) {
        super(name);
    }
    public void setAnimalToTakeCareOf(Class type){
        if(employer == null)
            return;
        careFor = type;
    }

    public void setEmployer(Zoo employer) {
        this.employer = employer;
    }
    public boolean hasEmployer(){
        return this.employer != null;
    }
    public Zoo getEmployer(){
        return this.employer;
    }

    public Collection<iAnimal> getAllAnimals() {
        return employer.getAnimalsByType(careFor);
    }
    public Collection<Compound> getAllCompoundsByType(){
        HashSet<Compound> set = new HashSet<>();
        for( Compound c : employer.getCompounds()){
            if(c.isAnimalClassCompatible( careFor )){
                set.add( c );
            }
        }
        return set;
    }
}
