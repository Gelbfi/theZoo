package compounds;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.*;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import static org.junit.Assert.assertEquals;

public class animalInteractionViceVersaTest {
    private Zoo getNewTestZoo(){
        Zoo zoo = new Zoo("TestZoo");
        zoo.addCompoundBird("BXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundMammal("MXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundFish("FXWW", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERWARM);

        return zoo;
    }
    @Test
    public void flipFlopAll(){
        Zoo zoo = getNewTestZoo();

        Parrot p = new Parrot("parrot");
        Eagle e = new Eagle("eagle");
        Leon l = new Leon("leon");
        Zebra z = new Zebra("zebra");
        BlowFish b = new BlowFish("bFish");
        WhaleShark w = new WhaleShark("wShark");

        zoo.getCompoundByID("MXCG").addAnimal(p);
        zoo.getCompoundByID("MXCG").addAnimal(b);
        zoo.getCompoundByID("BXCG").addAnimal(l);
        zoo.getCompoundByID("BXCG").addAnimal(w);
        zoo.getCompoundByID("FXWW").addAnimal(z);
        zoo.getCompoundByID("FXWW").addAnimal(e);

        assertEquals(0, zoo.getCompoundByID("MXCG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("BXCG").getAnimals().size());
        assertEquals(0, zoo.getCompoundByID("FXWW").getAnimals().size());
    }
}
