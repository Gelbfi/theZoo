package org.mytuc.dstruc.group12.entities.persons;

import org.mytuc.dstruc.group12.entities.animals.iAnimal;

import java.util.ArrayList;
import java.util.HashMap;

public class Employee extends Person {
    private HashMap<Integer,iAnimal> takesCareOf;
    public Employee(String name) {
        super(name);
    }
    public void addAnimalToTakeCareOf(HashMap<Integer,iAnimal> animals){
        takesCareOf = animals;
    }
}
