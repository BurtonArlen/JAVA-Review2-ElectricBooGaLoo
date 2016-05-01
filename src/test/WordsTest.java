import org.junit.*;
import static org.junit.Assert.*;


public class WordsTest {
  @After
  public void shred() {
    Words.noWords();
    Definition.noDefs();
  }
  @Test
  public void category_instantiatesCorrectly_true() {
    Words testWords = new Words("hella");
    assertEquals(true, testWords instanceof Words);
  }
  
}
