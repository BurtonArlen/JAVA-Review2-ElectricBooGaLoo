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

  public Boolean doesExist(){
    return true;
  }

  public static ArrayList<Definition> all(){
    return defs;
  }

  public static void noDefs() {
    defs.clear();
  }

  public int getId(){
    return mId;
  }

  public static Definition locate(int id){
    try{
      return defs.get(id-1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }


}
