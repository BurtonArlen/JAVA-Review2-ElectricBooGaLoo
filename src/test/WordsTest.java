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
  @Test
  public void haveDefine_categoryInstantiatesWithName_String() {
    Words testWords = new Words("hella");
    assertEquals("hella", testWords.getWord());
  }
  @Test
  public void all_returnsAllInstancesOfWords_true() {
    Words hellaWords = new Words("hella");
    Words dopeWords = new Words("dope");
    assertTrue(Words.all().contains(hellaWords));
    assertTrue(Words.all().contains(dopeWords));
  }
  @Test
  public void noWords_emptiesAllCategoriesFromList_0() {
    Words testWords = new Words("hella");
    Words.noWords();
    assertEquals(Words.all().size(), 0);
  }
  @Test
  public void getId_categoriesInstantiateWithAnId_1() {
    Words testWords = new Words("hella");
    assertEquals(1, testWords.getId());
  }
  @Test
  public void locate_returnsWordsWithSameId_dopeWords() {
    Words hellaWords = new Words("hella");
    Words dopeWords = new Words("dope");
    assertEquals(Words.locate(dopeWords.getId()), dopeWords);
  }
  @Test
  public void locate_returnsNullWhenNoWordsFound_null() {
    assertTrue(Words.locate(999) == null);
  }
}
