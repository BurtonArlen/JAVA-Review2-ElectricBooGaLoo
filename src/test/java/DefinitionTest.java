
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @After public void burn() {
    Definition.noDefs();
  }

  @Test public void def_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("It's totally the best, bro.");
    assertEquals(true, myDefinition.doesExist());
  }

  @Test public void def_instantiatesWithThaDef_String() {
    Definition myDefinition = new Definition("It's totally the best, bro.");
    assertEquals("It's totally the best, bro.", myDefinition.getThaDef());
  }

  @Test public void all_returnsAllInstancesOfDef_true() {
    Definition radDefinition = new Definition("It's totally the best, bro.");
    Definition wickedDefinition = new Definition("FoReal, man.");
    assertTrue(Definition.all().contains(radDefinition));
    assertTrue(Definition.all().contains(wickedDefinition));
  }

  @Test public void noDefs_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("It's totally the best, bro.");
    Definition.noDefs();
    assertEquals(Definition.all().size(), 0);
  }

  @Test public void getId_defInstantiateWithAnID_1() {
    Definition.noDefs();
    Definition myDefinition = new Definition("It's totally the best, bro.");
    assertEquals(1, myDefinition.getId());
  }

  @Test public void locate_returnsDefinitionWithSameId_wickedDefinition() {
    Definition radDefinition = new Definition("It's totally the best, bro.");
    Definition wickedDefinition = new Definition("FoReal, man.");
    assertEquals(Definition.locate(wickedDefinition.getId()), wickedDefinition);
  }

  @Test public void locate_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.locate(999) == null);
  }

}
