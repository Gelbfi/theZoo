package org.mytuc.dstruc.group12.entities.persons;

import org.mytuc.dstruc.group12.entities.compounds.Compound;

import java.util.ArrayList;

public abstract class Person {
    private String name;
    private ArrayList<Compound> route;

    Person(String name){
        this.name = name;
        route = new ArrayList<>();
    }
    public String getName(){ return name; }
    public void addCompound(Compound addedOne){ route.add( addedOne ); }

    public ArrayList<Compound> getRoute() {
        return route;
    }
}
