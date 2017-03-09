package Util;
import java.io.File;
import java.io.IOException;

public class Type extends File
{
  
  private static String t01 = ".pic" 
                      , t02 = ".ani"
                      , t03 = ".cre";
  private static String goal= "sdcard/File/";
                      
  
  private String _path = "";                    
  public String path(){
    
      return this._path;
    }                    
                      
  public Type(String path,String name){
    
      super(goal+path);
        
      this._path = goal+path+"/" +name;
      
      mkdirs();

  }
  public Type(String name){
    super(name);
  }
  
  public static String picture()
  {
    return t01;
  }
  
  public String gif()
  {
    return t02;
  }
  
  public String create()
  {
    return t03;
  }
  
}
