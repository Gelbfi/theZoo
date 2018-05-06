package org.mytuc.dstruc.group12.entities.animals;

public class Parrot extends Bird {
    public Parrot(String name) {
        super(name, AnimalDangerType.HARMLESS, AnimalSpaceType.MAX, AnimalHabitType.CAGE);
    }
}
