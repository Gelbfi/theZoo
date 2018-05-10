package entities;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.Leon;
import org.mytuc.dstruc.group12.entities.animals.Mammal;
import org.mytuc.dstruc.group12.entities.animals.Zebra;
import org.mytuc.dstruc.group12.entities.persons.Employee;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import static org.junit.Assert.assertEquals;

public class staffTest {
    private Zoo getNewTestZoo(){
        Zoo zoo = new Zoo("ZooPersonal");
        zoo.addCompoundBird("BXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundMammal("MXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundMammal("MXRG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundFish("FXWW", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERWARM);

        return zoo;
    }
    @Test
    public void routesAssignment(){
        Zoo zoo = getNewTestZoo();
        Employee v = new Employee("Hans Dampf");
        v.addCompound( zoo.getCompoundByID("BXCG") );
        assertEquals(1, v.getRoute().size());

        v.addCompound( zoo.getCompoundByID("BXCG") );
        assertEquals(1, v.getRoute().size());

        v.addCompound( zoo.getCompoundByID("MXCG") );
        assertEquals(2, v.getRoute().size());

        v.addCompound( zoo.getCompoundByID("BXCG") );
        assertEquals(3, v.getRoute().size());

    }
    @Test
    public void animalList(){
        Zoo zoo = getNewTestZoo();

        Leon leon_1 = new Leon("leon 1");
        Leon leon_2 = new Leon("leon 2");
        Leon leon_3 = new Leon("leon 3");
        Leon leon_4 = new Leon("leon 4");

        Employee e = new Employee("The one without animals");
        e.setEmployer( zoo );
        e.setAnimalToTakeCareOf( Mammal.class );
        assertEquals(0, e.getAllAnimals().size());

        zoo.getCompoundByID("MXCG").addAnimal( leon_1 );
        zoo.getCompoundByID("MXCG").addAnimal( leon_2 );
        zoo.getCompoundByID("MXCG").addAnimal( leon_3 );
        zoo.getCompoundByID("MXCG").addAnimal( leon_4 );

        assertEquals(4, e.getAllAnimals().size());

        leon_1.removeMe();

        assertEquals(4, e.getAllAnimals().size());

        Zebra zebra_1 = new Zebra("zebra 1");
        Zebra zebra_2 = new Zebra("zebra 2");

        zoo.getCompoundByID("MXRG").addAnimal( zebra_1 );
        zoo.getCompoundByID("MXRG").addAnimal( zebra_2 );

        assertEquals(6, e.getAllAnimals().size());
    }
    @Test
    public void compoundList(){
        Zoo zoo = getNewTestZoo();
        Employee e = new Employee("The one without animals");
        e.setEmployer( zoo );
        e.setAnimalToTakeCareOf( Mammal.class );

        assertEquals(2, e.getAllCompoundsByType().size());
    }
}
