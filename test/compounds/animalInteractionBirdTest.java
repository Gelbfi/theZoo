package compounds;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.Eagle;
import org.mytuc.dstruc.group12.entities.animals.Parrot;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import static org.junit.Assert.assertEquals;

public class animalInteractionBirdTest {
    private Zoo getNewTestZooAir(){
        Zoo zoo = new Zoo("TestZoo");
        zoo.addCompoundBird("AXRG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundBird("AIRG", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.RANGE);
        zoo.addCompoundBird("AXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundBird("AICG", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundBird("AXWC", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERCOLD);

        return zoo;
    }
    @Test
    public void birdTo(){
        Zoo zoo = getNewTestZooAir();

        Eagle eagle_1 = new Eagle("eagleClone");
        Eagle eagle_2 = new Eagle("eagleClone");
        Eagle eagle_3 = new Eagle("eagleClone");
        Eagle eagle_4 = new Eagle("eagleClone");
        Eagle eagle_5 = new Eagle("eagleClone");

        zoo.getCompoundByID("AXRG").addAnimal( eagle_1 );
        zoo.getCompoundByID("AIRG").addAnimal( eagle_2 );
        zoo.getCompoundByID("AXCG").addAnimal( eagle_3 );
        zoo.getCompoundByID("AICG").addAnimal( eagle_4 );
        zoo.getCompoundByID("AXWC").addAnimal( eagle_5 );

        assertEquals(0, zoo.getCompoundByID("AXRG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("AIRG").getAnimals().size());
        assertEquals(1, zoo.getCompoundByID("AXCG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("AICG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("AXWC").getAnimals().size());
    }
    @Test
    public void aggressiveBirdIntoFullCompound(){
        Zoo zoo = getNewTestZooAir();

        Eagle eagle_1 = new Eagle("eagleClone");
        Parrot parrot_2 = new Parrot("parrot1");
        Parrot parrot_3 = new Parrot("parrot2");
        Parrot parrot_4 = new Parrot("parrot3");
        Parrot parrot_5 = new Parrot("parrot4");

        zoo.getCompoundByID("AXCG").addAnimal(parrot_2);
        zoo.getCompoundByID("AXCG").addAnimal(parrot_3);
        zoo.getCompoundByID("AXCG").addAnimal(parrot_4);
        zoo.getCompoundByID("AXCG").addAnimal(parrot_5);

        assertEquals(4, zoo.getCompoundByID("AXCG").getAnimals().size());

        zoo.getCompoundByID("AXCG").addAnimal(eagle_1);

        assertEquals(1, zoo.getCompoundByID("AXCG").getAnimals().size());
    }
    @Test
    public void aggressiveBirdIsWaitingCompound(){
        Zoo zoo = getNewTestZooAir();

        Eagle eagle_1 = new Eagle("eagleClone");
        Parrot parrot_2 = new Parrot("parrot1");
        Parrot parrot_3 = new Parrot("parrot2");
        Parrot parrot_4 = new Parrot("parrot3");
        Parrot parrot_5 = new Parrot("parrot4");

        zoo.getCompoundByID("AXCG").addAnimal(eagle_1);

        assertEquals(1, zoo.getCompoundByID("AXCG").getAnimals().size());

        zoo.getCompoundByID("AXCG").addAnimal(parrot_2);
        zoo.getCompoundByID("AXCG").addAnimal(parrot_3);
        zoo.getCompoundByID("AXCG").addAnimal(parrot_4);
        zoo.getCompoundByID("AXCG").addAnimal(parrot_5);

        assertEquals(1, zoo.getCompoundByID("AXCG").getAnimals().size());
    }
}
