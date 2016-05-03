import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class Dictionary {
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/addWords.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Words newWords = new Words(word);
      model.put("template", "templates/createDefine.vtl");
      model.put("word", newWords);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitionPost", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Words word = Words.locate(Integer.parseInt(request.queryParams("wordId")));
      String define = request.queryParams("def");
      Definition definition = new Definition(define);
      word.addDefine(definition);
      model.put("word", word);
      model.put("template", "templates/dictionaryPage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Words word = Words.locate(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id/definition/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Words word = Words.locate(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/createDefine.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
