import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule public static ServerRule server = new ServerRule();

  @Test public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("View Dictionary");
  }

  @Test public void taskIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Holla");
    submit(".btn");
    assertThat(pageSource()).contains("Holla Definitions:");
  }
  //
  // @Test public void taskIsDisplayedTest() {
  //   goTo("http://localhost:4567/todos/new");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   click("a", withText("view list"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  // }
  //
  // @Test public void multipleTasksAreDisplayedTest() {
  //   goTo("http://localhost:4567/todos/new");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   goTo("http://localhost:4567/todos/new");
  //   fill("#description").with("Buy groceries");
  //   submit(".btn");
  //   click("a", withText("view list"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  //   assertThat(pageSource()).contains("Buy groceries");
  // }
  //
  // @Test public void taskShowPageDisplaysDescription() {
  //   goTo("http://localhost:4567/todos/new");
  //   fill("#description").with("Do the dishes");
  //   submit(".btn");
  //   click("a", withText("view list"));
  //   click("a", withText("Do the dishes"));
  //   assertThat(pageSource()).contains("Do the dishes");
  // }
  //
  // @Test public void taskNotFoundMessageShown() {
  //   goTo("http://localhost:4567/todos/999");
  //   assertThat(pageSource()).contains("Item not found");
  // }

}
