package DefineFile;
import java.io.File;
import Util.Type;
import java.io.IOException;

public class FileType 
{
    private String goal ="";
  
    public Type t(String s){

        Type t = new Type(s);

        return t;

      }
  
  public FileType(Type t)
  {
    goal = t.path();
    
  }
  
  public void createPic(Type t) 
  {
    try
      {
        t=t(goal+t.picture());
        
        t.createNewFile( );
        
        System.out.println("Picture was created:" +goal );
      }
    catch (IOException e)
      {}
     
    return ;
  }
  
    public void createAni(Type t) 
      {
        try
          {
            t=t(goal+t.gif());
            
            t.createNewFile();
            
            System.out.println("Ani was created:" +goal );
          }
        catch (IOException e)
          {}

        return ;
      }
    
      
    public void createCre(Type t) 
      {
        try
          {
            t=t(goal+t.create());
            
            t.createNewFile();
            
            System.out.println("Create idea was created:" +goal );
          }
        catch (IOException e)
          {}

        return ;
      }
    
}
