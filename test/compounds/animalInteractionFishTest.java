package compounds;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.animals.BlowFish;
import org.mytuc.dstruc.group12.entities.animals.WhaleShark;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import static org.junit.Assert.assertEquals;

public class animalInteractionFishTest {
    private Zoo getNewTestZooWater(){
        Zoo zoo = new Zoo("TestZoo");
        zoo.addCompoundFish("FXWW", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERWARM);
        zoo.addCompoundFish("FIWW", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.WATERWARM);
        zoo.addCompoundFish("FXWC", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERCOLD);
        zoo.addCompoundFish("FIWC", Animal.AnimalSpaceType.MIN, Animal.AnimalHabitType.WATERCOLD);
        zoo.addCompoundFish("FXRR", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.RANGE);

        return zoo;
    }
    @Test
    public void fishTank(){
        Zoo zoo = getNewTestZooWater();

        WhaleShark fish_1 = new WhaleShark("whaleClone");
        WhaleShark fish_2 = new WhaleShark("whaleClone");
        WhaleShark fish_3 = new WhaleShark("whaleClone");
        WhaleShark fish_4 = new WhaleShark("whaleClone");

        zoo.getCompoundByID("FXWW").addAnimal( fish_1 );
        zoo.getCompoundByID("FIWW").addAnimal( fish_2 );
        zoo.getCompoundByID("FXWC").addAnimal( fish_3 );
        zoo.getCompoundByID("FXRR").addAnimal( fish_4 );

        assertEquals(1, zoo.getCompoundByID("FXWW").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("FIWW").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("FXWC").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("FXRR").getAnimals().size());
    }
    @Test
    public void aggressiveFishIntoFullTank(){
        Zoo zoo = getNewTestZooWater();

        WhaleShark fish_1 = new WhaleShark("aggFish");
        BlowFish fish_2 = new BlowFish("smallFish1");
        BlowFish fish_3 = new BlowFish("smallFish2");
        BlowFish fish_4 = new BlowFish("smallFish3");
        BlowFish fish_5 = new BlowFish("smallFish4");

        zoo.getCompoundByID("FXWW").addAnimal(fish_2);
        zoo.getCompoundByID("FXWW").addAnimal(fish_3);
        zoo.getCompoundByID("FXWW").addAnimal(fish_4);
        zoo.getCompoundByID("FXWW").addAnimal(fish_5);

        assertEquals(4, zoo.getCompoundByID("FXWW").getAnimals().size());

        zoo.getCompoundByID("FXWW").addAnimal(fish_1);

        assertEquals(1, zoo.getCompoundByID("FXWW").getAnimals().size());
    }
    @Test
    public void aggressiveFishIsWaitingInTank(){
        Zoo zoo = getNewTestZooWater();

        WhaleShark fish_1 = new WhaleShark("aggFish");
        BlowFish fish_2 = new BlowFish("smallFish1");
        BlowFish fish_3 = new BlowFish("smallFish2");
        BlowFish fish_4 = new BlowFish("smallFish3");
        BlowFish fish_5 = new BlowFish("smallFish4");

        zoo.getCompoundByID("FXWW").addAnimal(fish_1);

        assertEquals(1, zoo.getCompoundByID("FXWW").getAnimals().size());

        zoo.getCompoundByID("FXWW").addAnimal(fish_2);
        zoo.getCompoundByID("FXWW").addAnimal(fish_3);
        zoo.getCompoundByID("FXWW").addAnimal(fish_4);
        zoo.getCompoundByID("FXWW").addAnimal(fish_5);

        assertEquals(1, zoo.getCompoundByID("FXWW").getAnimals().size());
    }
}
