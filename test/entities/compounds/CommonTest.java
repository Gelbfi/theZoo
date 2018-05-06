package entities.compounds;

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
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommonTest {
    @Test
    public void initializer(){
        Compound cM = new MammalCompound("the Leon", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        Compound cA = new FishTank("the Fish", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.CAGE);
        Compound cC = new BirdCage("the Flamingo", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
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
        Compound cParrots = new BirdCage("Papageiengehege", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        Compound cEagle = new BirdCage("Adlergehege", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        Compound cPenguin = new BirdCage("Pinguingehege", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        zoo.addCompound( cParrots );
        zoo.addCompound( cEagle );
        zoo.addCompound( cPenguin );

        Compound cSteppe = new MammalCompound("Steppe", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        Compound cForest = new MammalCompound("Wald", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        Compound cDesert = new MammalCompound("Wueste", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompound( cSteppe );
        zoo.addCompound( cForest );
        zoo.addCompound( cDesert );

        Compound cWhaleShark = new FishTank("Walhaibecken", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERWARM);
        Compound cBlowFishTank = new FishTank("Kugelfischtank", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.WATERWARM);
        zoo.addCompound( cWhaleShark );
        zoo.addCompound( cBlowFishTank );

        assertEquals(8, zoo.getCompounds().size());
        /*
         * TASK II
         */
        Parrot parrot_1 = new Parrot("Tick");
        Parrot parrot_2 = new Parrot("Trick");
        Parrot parrot_3 = new Parrot("Track");
        cParrots.addAnimal( parrot_1 );
        cParrots.addAnimal( parrot_2 );
        cParrots.addAnimal( parrot_3 );

        assertEquals(3, cParrots.getAnimals().size());

        /*
         * TASK III
         */
        Leon leon_1 = new Leon("Tywin");
        Leon leon_2 = new Leon("Jaime");
        Leon leon_3 = new Leon("Cersei");
        Leon leon_4 = new Leon("Joffrey");
        cDesert.addAnimal( leon_1 );
        cDesert.addAnimal( leon_2 );
        cDesert.addAnimal( leon_3 );
        cDesert.addAnimal( leon_4 );

        assertEquals(4, cDesert.getAnimals().size());

        /*
         * TASK IV
         */
        Zebra zebra_1 = new Zebra("Zalana");
        Zebra zebra_2 = new Zebra("Arya");
        Zebra zebra_3 = new Zebra("Bran");
        Zebra zebra_4 = new Zebra("Robb");
        Zebra zebra_5 = new Zebra("Eddard");
        cForest.addAnimal( zebra_4 );
        cForest.addAnimal( zebra_5 );
        cSteppe.addAnimal( zebra_1 );
        cSteppe.addAnimal( zebra_2 );
        cSteppe.addAnimal( zebra_3 );

        assertEquals(2, cForest.getAnimals().size());
        assertEquals(3, cSteppe.getAnimals().size());

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
        cBlowFishTank.addAnimal( blowFish_1 );
        cBlowFishTank.addAnimal( blowFish_2 );
        cBlowFishTank.addAnimal( blowFish_3 );
        cBlowFishTank.addAnimal( blowFish_4 );
        cBlowFishTank.addAnimal( blowFish_5 );
        cBlowFishTank.addAnimal( blowFish_6 );
        cBlowFishTank.addAnimal( blowFish_7 );
        cBlowFishTank.addAnimal( blowFish_8 );
        cBlowFishTank.addAnimal( blowFish_9 );
        cBlowFishTank.addAnimal( blowFish_10 );

        assertEquals(10, cBlowFishTank.getAnimals().size());

        /*
         * TASK VI
         */
        WhaleShark whale_1 = new WhaleShark("Moby");
        WhaleShark whale_2 = new WhaleShark("Dick");
        cWhaleShark.addAnimal( whale_1 );
        cWhaleShark.addAnimal( whale_2 );

        assertEquals(2, cWhaleShark.getAnimals().size());

        /*
         * TASK VII
         */
        Eagle eagle_1 = new Eagle("American");
        Eagle eagle_2 = new Eagle("Dream");
        cEagle.addAnimal( eagle_1 );
        cEagle.addAnimal( eagle_2 );

        assertEquals(2, cEagle.getAnimals().size());

        /*
         * TASK VIII
         */
        Employee employee_1 = new Employee("Ramsay");
        Employee employee_2 = new Employee("Sam");
        Employee employee_3 = new Employee("Daernerys");
        zoo.addEmployee( employee_1 );
        zoo.addEmployee( employee_2 );
        zoo.addEmployee( employee_3 );
        employee_1.addAnimalToTakeCareOf( Mammal.getListOfAllAnimals());
        employee_2.addAnimalToTakeCareOf( WaterAnimal.getListOfAllAnimals());
        employee_3.addAnimalToTakeCareOf( Bird.getListOfAllAnimals());

        assertEquals(3, zoo.getEmployees().size());

        /*
         * TASK IX
         */
        Visitor visitor_1 = new Visitor("Catelyn");
            visitor_1.addCompound( cDesert );
        Visitor visitor_2 = new Visitor("Aerys");
            visitor_2.addCompound( cEagle );
        Visitor visitor_3 = new Visitor("Bronn");
            visitor_3.addCompound( cBlowFishTank );
        Visitor visitor_4 = new Visitor("Sansa");
            visitor_4.addCompound( cWhaleShark );
        Visitor visitor_5 = new Visitor("Willy");
            visitor_5.addCompound( cForest );
            visitor_5.addCompound( cBlowFishTank );

        zoo.addVisitor(visitor_1);
        zoo.addVisitor(visitor_2);
        zoo.addVisitor(visitor_3);
        zoo.addVisitor(visitor_4);
        zoo.addVisitor(visitor_5);

        assertEquals(5, zoo.getVisitors().size());

        /*
         * TASK X
         */
        leon_4.moveTo( cWhaleShark );

        assertEquals(2, cWhaleShark.getAnimals().size());
        assertEquals(3, cDesert.getAnimals().size());

        /*
         * TASK XI
         */
        leon_1.moveTo( cDesert );

        assertEquals(3, cDesert.getAnimals().size());

        /*
         * TASK XII
         */
        visitor_4.addCompound( cSteppe );

        List<Compound> route = visitor_4.getRoute();
        assertEquals(2, route.size());
        assertEquals(route.get(0).getName(), cWhaleShark.getName());
        assertEquals(route.get(1).getName(), cSteppe.getName());
        /*
         * TASK XIII
         */
        leon_3.moveTo( cEagle );
        assertEquals(2, cDesert.getAnimals().size());
        assertEquals(2, cEagle.getAnimals().size());

        ArrayList<Animal> list = cParrots.getAnimals();
        assertEquals(3, list.size());
        assertEquals(list.get(0).getName(), parrot_1.getName());
        assertEquals(list.get(1).getName(), parrot_2.getName());
        assertEquals(list.get(2).getName(), parrot_3.getName());
    }
}
