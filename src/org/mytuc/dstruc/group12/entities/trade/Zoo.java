package org.mytuc.dstruc.group12.entities.trade;

import org.mytuc.dstruc.group12.entities.compounds.Compound;
import org.mytuc.dstruc.group12.entities.persons.Employee;
import org.mytuc.dstruc.group12.entities.persons.Visitor;
import org.mytuc.dstruc.group12.helper.ArrayHelper;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zoo {
    private Compound[] compounds;
    private Visitor[] visitors;
    private Employee[] employees;
    private String name;

    public Zoo(String theName){
        compounds = new Compound[10];
        visitors = new Visitor[20];
        employees = new Employee[20];
        name = theName;
    }

    public String getName() {
        return name;
    }

    public boolean addCompound(Compound compound) {
        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.compounds));
        if(index > -1)
            this.compounds[index] = compound;
        return index > 1;
    }

    public boolean addEmployee(Employee employee) {
        int index = ArrayHelper.getFreeEntry(Arrays.asList(this.employees));
        if(index > -1)
            this.employees[index] = employee;
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
}
