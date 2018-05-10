package compounds;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.Leon;
import org.mytuc.dstruc.group12.entities.animals.Zebra;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import static org.junit.Assert.assertEquals;

public class animalInteractionMammalTest {
    private Zoo getNewTestZooLand(){
        Zoo zoo = new Zoo("TestZoo");
        zoo.addCompoundMammal("MXRG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundMammal("MIRG", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundMammal("MXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundMammal("MICG", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundMammal("MXWC", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERCOLD);

        return zoo;
    }
    @Test
    public void mammalsTo(){
        Zoo zoo = getNewTestZooLand();

        Leon leon_1 = new Leon("leonClone");
        Leon leon_2 = new Leon("leonClone");
        Leon leon_3 = new Leon("leonClone");
        Leon leon_4 = new Leon("leonClone");
        Leon leon_5 = new Leon("leonClone");

        zoo.getCompoundByID("MXRG").addAnimal( leon_1 );
        zoo.getCompoundByID("MIRG").addAnimal( leon_2 );
        zoo.getCompoundByID("MXCG").addAnimal( leon_3 );
        zoo.getCompoundByID("MICG").addAnimal( leon_4 );
        zoo.getCompoundByID("MXWC").addAnimal( leon_5 );

        assertEquals(0, zoo.getCompoundByID("MXRG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("MIRG").getAnimals().size());
        assertEquals(1, zoo.getCompoundByID("MXCG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("MICG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("MXWC").getAnimals().size());
    }
    @Test
    public void aggressiveMammalIntoFullCompound(){
        Zoo zoo = getNewTestZooLand();

        Leon leon_1 = new Leon("leonClone");
        Zebra leon_2 = new Zebra("zebra1");
        Zebra leon_3 = new Zebra("zebra2");
        Zebra leon_4 = new Zebra("zebra3");
        Zebra leon_5 = new Zebra("zebra4");

        zoo.getCompoundByID("MXCG").addAnimal(leon_2);
        zoo.getCompoundByID("MXCG").addAnimal(leon_3);
        zoo.getCompoundByID("MXCG").addAnimal(leon_4);
        zoo.getCompoundByID("MXCG").addAnimal(leon_5);

        assertEquals(4, zoo.getCompoundByID("MXCG").getAnimals().size());

        zoo.getCompoundByID("MXCG").addAnimal(leon_1);

        assertEquals(1, zoo.getCompoundByID("MXCG").getAnimals().size());
    }
    @Test
    public void aggressiveMammalIsWaitingCompound(){
        Zoo zoo = getNewTestZooLand();

        Leon leon_1 = new Leon("leonClone");
        Zebra leon_2 = new Zebra("zebra1");
        Zebra leon_3 = new Zebra("zebra2");
        Zebra leon_4 = new Zebra("zebra3");
        Zebra leon_5 = new Zebra("zebra4");

        zoo.getCompoundByID("MXCG").addAnimal(leon_1);

        assertEquals(1, zoo.getCompoundByID("MXCG").getAnimals().size());

        zoo.getCompoundByID("MXCG").addAnimal(leon_2);
        zoo.getCompoundByID("MXCG").addAnimal(leon_3);
        zoo.getCompoundByID("MXCG").addAnimal(leon_4);
        zoo.getCompoundByID("MXCG").addAnimal(leon_5);

        assertEquals(1, zoo.getCompoundByID("MXCG").getAnimals().size());
    }
}
