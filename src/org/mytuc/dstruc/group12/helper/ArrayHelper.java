package org.mytuc.dstruc.group12.helper;

import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.compounds.Compound;
import org.mytuc.dstruc.group12.entities.persons.Person;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ArrayHelper {
    private ArrayHelper () {

    }
    public static int getFreeEntry(List typeArray) {
        for (int i = 0; i < typeArray.size(); i++)
            if (typeArray.get( i ) == null)
                return i;

        return -1;
    }
}
