import java.util.ArrayList;

public class Definition {
  private String mDefine;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();
  private int mId;

  public Definition(String description) {
    mDefine = description;
    instances.add(this);
    mId = instances.size();
  }

  public String getThaDef() {
    return mDefine;
  }

  public Boolean doesExist(){
    return true;
  }

  public static ArrayList<Definition> all(){
    return instances;
  }

  public static void noDefs() {
    instances.clear();
  }

  public int getId(){
    return mId;
  }

  public static Definition locate(int id){
    try{
      return instances.get(id-1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }


}
