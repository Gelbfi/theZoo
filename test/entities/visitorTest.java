package entities;

import org.junit.Test;
import org.mytuc.dstruc.group12.entities.animals.Animal;
import org.mytuc.dstruc.group12.entities.persons.Visitor;
import org.mytuc.dstruc.group12.entities.trade.Zoo;

import static org.junit.Assert.assertEquals;

public class visitorTest {
    private Zoo getNewTestZoo(){
        Zoo zoo = new Zoo("Zoo");
        zoo.addCompoundBird("BXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundMammal("MXCG", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.CAGE);
        zoo.addCompoundFish("FXWW", Animal.AnimalSpaceType.MAX, Animal.AnimalHabitType.WATERWARM);

        return zoo;
    }
    @Test
    public void routesAssignment(){
        Zoo zoo = getNewTestZoo();
        Visitor v = new Visitor("Hans Dampf");
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
    public void visiting(){
        Zoo zoo = getNewTestZoo();
        Visitor v = new Visitor("Hans Dampf");
        v.addCompound( zoo.getCompoundByID("BXCG") );
        v.addCompound( zoo.getCompoundByID("FXWW") );
        v.addCompound( zoo.getCompoundByID("MXCG") );

        assertEquals(true, v.getActiveCompound() == zoo.getCompoundByID("BXCG"));

        assertEquals(true, v.getNextCompounds().get(0) == zoo.getCompoundByID("FXWW"));
        assertEquals(2, v.getNextCompounds().size());

        v.setCompoundAsDone();
        assertEquals(true, v.getActiveCompound() == zoo.getCompoundByID("FXWW"));
        assertEquals(true, v.getNextCompounds().get(0) == zoo.getCompoundByID("MXCG"));
        assertEquals(1, v.getNextCompounds().size());
    }
}
