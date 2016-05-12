import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule public static ServerRule server = new ServerRule();

  @Test public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("YOUR OWN UPDATABLE DICTIONARY");
  }

  @Test public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Holla");
    submit("#wordButton");
    assertThat(pageSource()).contains("Add a new definition for Holla");
  }

  @Test public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Holla");
    submit("#wordButton");
    fill("#def").with("Boggle");
    click("#addDefine", withText("Add Definition"));
    assertThat(pageSource()).contains("All words in Dictionary");
  }

  @Test public void multipleWordsAreDisplayedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Holla");
    submit("#wordButton");
    fill("#def").with("Boggle");
    click("#addDefine", withText("Add Definition"));
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Rad");
    submit("#wordButton");
    fill("#def").with("Boggle");
    click("#addDefine", withText("Add Definition"));
    assertThat(pageSource()).contains("Holla");
    assertThat(pageSource()).contains("Rad");
  }

  @Test public void DefShowPageDisplaysDef() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Holla");
    submit("#wordButton");
    fill("#def").with("Boggle");
    click("#addDefine", withText("Add Definition"));
    click("#wordDef", withText("Holla"));
    assertThat(pageSource()).contains("Boggle");
  }


}
