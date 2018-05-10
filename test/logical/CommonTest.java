package logical;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.*;
import org.mytuc.dstruc.group12.entities.compounds.BirdCage;
import org.mytuc.dstruc.group12.entities.compounds.Compound;
import org.mytuc.dstruc.group12.entities.compounds.FishTank;
import org.mytuc.dstruc.group12.entities.compounds.MammalCompound;
import org.mytuc.dstruc.group12.entities.persons.Employee;
import org.mytuc.dstruc.group12.entities.persons.Person;
import org.mytuc.dstruc.group12.entities.persons.Visitor;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommonTest {
    @Test
    public void initializer(){
        Zoo zoo = new Zoo("Zoo");

        Compound cM = new MammalCompound(zoo,"the Leon", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        Compound cA = new FishTank(zoo,"the Fish", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.CAGE);
        Compound cC = new BirdCage(zoo,"the Flamingo", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        assertEquals("the Leon", cM.getName());
        assertEquals("the Fish", cA.getName());
        assertEquals("the Flamingo", cC.getName());

        Zoo z = new Zoo("Armadillo Ranch");
        assertEquals("Armadillo Ranch", z.getName());

        Person pV = new Visitor("Karl Marx");
        Person pS = new Employee("Mad Max");
        assertEquals("Karl Marx", pV.getName());
        assertEquals("Mad Max", pS.getName());

        Animal aE = new Eagle("Eagle Erny");
        Animal aP = new Parrot("Parrot Paul");
        Animal aZ = new Zebra("Zebra Zuzi");
        Animal aL = new Leon("Leon Lucas");
        Animal aW = new WhaleShark("Shark Stan");
        Animal aB = new BlowFish("Fish Ferdinand");
        assertEquals("Eagle Erny", aE.getName());
        assertEquals("Parrot Paul", aP.getName());
        assertEquals("Zebra Zuzi", aZ.getName());
        assertEquals("Leon Lucas", aL.getName());
        assertEquals("Shark Stan", aW.getName());
        assertEquals("Fish Ferdinand", aB.getName());
    }

    @Test
    public void finalTest(){
        Zoo zoo = new Zoo("Armadillo Ranch");

        /*
         * TASK I
         */
        zoo.addCompoundBird("Papageiengehege", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundBird("Adlergehege", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundBird("Pinguingehege", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);

        zoo.addCompoundMammal("Wald", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundMammal("Steppe", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundMammal("Wueste", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);

        zoo.addCompoundFish("Walhaibecken", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERWARM);
        zoo.addCompoundFish("Kugelfischtank", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.WATERWARM);

        assertEquals(8, zoo.getCompounds().size());

        /*
         * TASK II
         */
        Parrot parrot_1 = new Parrot("Tick");
        Parrot parrot_2 = new Parrot("Trick");
        Parrot parrot_3 = new Parrot("Track");
        if(!zoo.hasCompoundWithID("papa"))
            assertEquals(true, zoo.hasCompoundWithID("papa"));
        else {
            zoo.getCompoundByID("papa").addAnimal(parrot_1);
            zoo.getCompoundByID("papa").addAnimal(parrot_2);
            zoo.getCompoundByID("papa").addAnimal(parrot_3);

            assertEquals(3, zoo.getCompoundByID("papa").getAnimals().size());
        }

        /*
         * TASK III
         */
        Leon leon_1 = new Leon("Tywin");
        Leon leon_2 = new Leon("Jaime");
        Leon leon_3 = new Leon("Cersei");
        Leon leon_4 = new Leon("Joffrey");

        if(!zoo.hasCompoundWithID("wues"))
            assertEquals(true, zoo.hasCompoundWithID("wues"));
        else {
            zoo.getCompoundByID("wues").addAnimal( leon_1 );
            zoo.getCompoundByID("wues").addAnimal( leon_2 );
            zoo.getCompoundByID("wues").addAnimal( leon_3 );
            zoo.getCompoundByID("wues").addAnimal( leon_4 );

            assertEquals(4, zoo.getCompoundByID("wues").getAnimals().size());
        }

        /*
         * TASK IV
         */
        Zebra zebra_1 = new Zebra("Zalana");
        Zebra zebra_2 = new Zebra("Arya");
        Zebra zebra_3 = new Zebra("Bran");
        Zebra zebra_4 = new Zebra("Robb");
        Zebra zebra_5 = new Zebra("Eddard");
        if(!zoo.hasCompoundWithID("wald") || !zoo.hasCompoundWithID("step"))
            assertEquals(true, zoo.hasCompoundWithID("wald") && zoo.hasCompoundWithID("step"));
        else {
            zoo.getCompoundByID("step").addAnimal(zebra_4);
            zoo.getCompoundByID("step").addAnimal(zebra_5);
            zoo.getCompoundByID("step").addAnimal(zebra_1);
            zoo.getCompoundByID("wald").addAnimal(zebra_2);
            zoo.getCompoundByID("wald").addAnimal(zebra_3);

            assertEquals(2, zoo.getCompoundByID("wald").getAnimals().size());
            assertEquals(3, zoo.getCompoundByID("step").getAnimals().size());
        }

        /*
         * TASK V
         */
        BlowFish blowFish_1 = new BlowFish("Albert");
        BlowFish blowFish_2 = new BlowFish("Bertholt");
        BlowFish blowFish_3 = new BlowFish("Casimir");
        BlowFish blowFish_4 = new BlowFish("Derrick");
        BlowFish blowFish_5 = new BlowFish("Erich");
        BlowFish blowFish_6 = new BlowFish("Friedhelm");
        BlowFish blowFish_7 = new BlowFish("Giesbert");
        BlowFish blowFish_8 = new BlowFish("Helmut");
        BlowFish blowFish_9 = new BlowFish("Ingebourg");
        BlowFish blowFish_10 = new BlowFish("Jemima");
        if(!zoo.hasCompoundWithID("kuge"))
            assertEquals(true, zoo.hasCompoundWithID("kuge"));
        else {
            zoo.getCompoundByID("kuge").addAnimal(blowFish_1);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_2);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_3);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_4);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_5);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_6);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_7);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_8);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_9);
            zoo.getCompoundByID("kuge").addAnimal(blowFish_10);

            assertEquals(10, zoo.getCompoundByID("kuge").getAnimals().size());
        }

        /*
         * TASK VI
         */
        WhaleShark whale_1 = new WhaleShark("Moby");
        WhaleShark whale_2 = new WhaleShark("Dick");
        if(!zoo.hasCompoundWithID("walh"))
            assertEquals(true, zoo.hasCompoundWithID("walh"));
        else {
            zoo.getCompoundByID("walh").addAnimal(whale_1);
            zoo.getCompoundByID("walh").addAnimal(whale_2);

            assertEquals(2, zoo.getCompoundByID("walh").getAnimals().size());
        }
        /*
         * TASK VII
         */
        Eagle eagle_1 = new Eagle("American");
        Eagle eagle_2 = new Eagle("Dream");
        if(!zoo.hasCompoundWithID("adle"))
            assertEquals(true, zoo.hasCompoundWithID("adle"));
        else {
            zoo.getCompoundByID("adle").addAnimal(eagle_1);
            zoo.getCompoundByID("adle").addAnimal(eagle_2);

            assertEquals(2, zoo.getCompoundByID("adle").getAnimals().size());
        }
        /*
         * TASK VIII
         */
        Employee employee_1 = new Employee("Ramsay");
        Employee employee_2 = new Employee("Sam");
        Employee employee_3 = new Employee("Daernerys");
        zoo.addEmployee( employee_1 );
        zoo.addEmployee( employee_2 );
        zoo.addEmployee( employee_3 );
        employee_1.setAnimalToTakeCareOf( Mammal.class );
        employee_2.setAnimalToTakeCareOf( WaterAnimal.class );
        employee_3.setAnimalToTakeCareOf( Bird.class );

        assertEquals(3, zoo.getEmployees().size());

        /*
         * TASK IX
         */
        Visitor visitor_1 = new Visitor("Catelyn");
            visitor_1.addCompound( zoo.getCompoundByID("wues") );
        Visitor visitor_2 = new Visitor("Aerys");
            visitor_2.addCompound( zoo.getCompoundByID("adle") );
        Visitor visitor_3 = new Visitor("Bronn");
            visitor_3.addCompound( zoo.getCompoundByID("kuge") );
        Visitor visitor_4 = new Visitor("Sansa");
            visitor_4.addCompound( zoo.getCompoundByID("walh") );
        Visitor visitor_5 = new Visitor("Willy");
            visitor_5.addCompound( zoo.getCompoundByID("walh") );
            visitor_5.addCompound( zoo.getCompoundByID("kuge") );

        zoo.addVisitor(visitor_1);
        zoo.addVisitor(visitor_2);
        zoo.addVisitor(visitor_3);
        zoo.addVisitor(visitor_4);
        zoo.addVisitor(visitor_5);

        assertEquals(5, zoo.getVisitors().size());

        /*
         * TASK X
         */
        leon_4.moveTo( zoo.getCompoundByID("walh") );

        assertEquals(2, zoo.getCompoundByID("walh").getAnimals().size());
        assertEquals(3, zoo.getCompoundByID("wues").getAnimals().size());

        /*
         * TASK XI
         */
        leon_1.moveTo( zoo.getCompoundByID("wues") );

        assertEquals(3, zoo.getCompoundByID("wues").getAnimals().size());

        /*
         * TASK XII
         */
        visitor_4.addCompound( zoo.getCompoundByID("step") );

        List<Compound> route = visitor_4.getRoute();
        assertEquals(2, route.size());
        assertEquals(route.get(0).getName(), zoo.getCompoundByID("walh").getName());
        assertEquals(route.get(1).getName(), zoo.getCompoundByID("step").getName());
        /*
         * TASK XIII
         */
        leon_3.moveTo( zoo.getCompoundByID("adle") );
        assertEquals(2, zoo.getCompoundByID("wues").getAnimals().size());
        assertEquals(2, zoo.getCompoundByID("adle").getAnimals().size());

        ArrayList<Animal> list = zoo.getCompoundByID("papa").getAnimals();
        assertEquals(3, list.size());
        assertEquals(list.get(0).getName(), parrot_1.getName());
        assertEquals(list.get(1).getName(), parrot_2.getName());
        assertEquals(list.get(2).getName(), parrot_3.getName());
    }
}
