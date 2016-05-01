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

}
