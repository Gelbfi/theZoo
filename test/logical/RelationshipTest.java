package logical;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.BlowFish;
import org.mytuc.dstruc.group12.entities.animals.Eagle;
import org.mytuc.dstruc.group12.entities.animals.Zebra;
import org.mytuc.dstruc.group12.entities.persons.Employee;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import static org.junit.Assert.assertEquals;

public class RelationshipTest {
    @Test
    public void compoundAndZoo(){
        Zoo zoo = new Zoo("theZoo");

        zoo.addCompoundFish("fish", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.WATERWARM);
        zoo.addCompoundMammal("mammal", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundBird("bird", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);

        assertEquals(true, zoo.getCompoundByID("fish").getZoo() == zoo);
        assertEquals(true, zoo.getCompoundByID("mamm").getZoo() == zoo);
        assertEquals(true, zoo.getCompoundByID("bird").getZoo() == zoo);

        assertEquals(3, zoo.getCompounds().size());
    }

    @Test
    public void personalAndZoo(){
        Zoo zoo = new Zoo("theZoo");

        Employee e1 = new Employee("e1");
        Employee e2 = new Employee("e2");
        Employee e3 = new Employee("e3");

        zoo.addEmployee(e1);
        zoo.addEmployee(e2);
        zoo.addEmployee(e3);

        assertEquals(true, e1.getEmployer() == zoo);
        assertEquals(true, e2.getEmployer() == zoo);
        assertEquals(true, e3.getEmployer() == zoo);

        assertEquals(3, zoo.getEmployees().size());
    }

    @Test
    public void animalAndZoo(){
        Eagle a1 = new Eagle("eagle1");
        Zebra a2 = new Zebra("zebra1");
        BlowFish a3 = new BlowFish("blow1");

        Zoo zoo = new Zoo("testZoo");
        zoo.addCompoundBird("eagles", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundMammal("zebras", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundFish("blows", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.WATERWARM);

        zoo.getCompoundByID("eagl").addAnimal( a1 );
        zoo.getCompoundByID("zebr").addAnimal( a2 );
        zoo.getCompoundByID("blow").addAnimal( a3 );

        assertEquals(3, zoo.getAllAnimals().size());

        assertEquals(true, a1.getZoo() == zoo);
        assertEquals(true, a2.getZoo() == zoo);
        assertEquals(true, a3.getZoo() == zoo);
    }
}
