import java.util.ArrayList;

public class Definition {
  private String mDefine;
  private static ArrayList<Definition> defs = new ArrayList<Definition>();
  private int mId;

  public Definition(String description) {
    mDefine = description;
    defs.add(this);
    mId = defs.size();
  }

  public String getThaDef() {
    return mDefine;
  }

}
