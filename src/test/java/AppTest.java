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

  @Test public void taskIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Holla");
    submit(".btn");
    assertThat(pageSource()).contains("Holla Definitions:");
  }

  @Test public void taskIsDisplayedTest() {
    goTo("http://localhost:4567/words/1");
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add Definition");
  }

  @Test public void multipleTasksAreDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Holla");
    submit(".btn");
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Rad");
    submit(".btn");
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Holla");
    assertThat(pageSource()).contains("Rad");
  }

  @Test public void taskShowPageDisplaysDescription() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Holla");
    submit(".btn");
    click("a", withText("Add a new definition"));
    click("a", withText("Holla"));
    fill("#def").with("Rad");
    submit(".btn");
    assertThat(pageSource()).contains("All words in Dictionary");

  }


}
