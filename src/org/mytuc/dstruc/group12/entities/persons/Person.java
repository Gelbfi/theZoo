package org.mytuc.dstruc.group12.entities.persons;

import org.mytuc.dstruc.group12.entities.compounds.Compound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Person {
    private String name;
    private ArrayList<Compound> route;

    Person(String name) {
        this.name = name;
        route = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCompound(Compound addedOne) {
        if (!route.isEmpty() && route.lastIndexOf(addedOne) == (route.size() - 1))
            return;

        route.add(addedOne);
    }

    public ArrayList<Compound> getRoute() {
        return route;
    }

    public boolean hasActiveCompound() {
        route.removeAll(Collections.singleton(null));
        return (route.size() > 0);
    }

    public Compound getActiveCompound() {
        route.removeAll(Collections.singleton(null));
        return (route.size() > 0) ? route.get(0) : null;
    }

    private boolean hasNextCompound() {
        route.removeAll(Collections.singleton(null));
        return (route.size() > 1);
    }

    public List<Compound> getNextCompounds() {
        if (!this.hasNextCompound())
            return new ArrayList<>();

        return route.subList(1, route.size());
    }

    public void setCompoundAsDone() {
        route.removeAll(Collections.singleton(null));
        if(this.route.size() > 0)
            this.route.set(0, null);
        route.removeAll(Collections.singleton(null));
    }
}
