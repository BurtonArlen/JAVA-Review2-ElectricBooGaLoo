import java.util.ArrayList;

public class Words {
  private String mWord;
  private static ArrayList<Words> werds = new ArrayList<Words>();
  private int mId;
  private ArrayList<Definition> mDefine;

  public Words(String word) {
    mWord = word;
    werds.add(this);
    mId = werds.size();
    mDefine = new ArrayList<Definition>();
  }

  public ArrayList<Definition> haveDefine() {
      return mDefine;
    }

  public void addDefine(Definition definition) {
    mDefine.add(definition);
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Words> all() {
    return werds;
  }

  public static void noWords() {
    werds.clear();
  }

  public int getId() {
    return mId;
  }

  public static Words locate(int id) {
    try {
      return werds.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
