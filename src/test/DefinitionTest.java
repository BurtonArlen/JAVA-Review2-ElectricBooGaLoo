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


}
