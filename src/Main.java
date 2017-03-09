import java.util.Scanner;
import Util.HLMFile;
import DefineFile.FileType;
import Util.Type;
import java.io.File;

public class Main
{
    
    static Type t = new Type ("java","mlh");
 
    static FileType ft= new FileType(t);
    public static void main(String[] args)
    {

      new test().test();
      
      ft.createPic(t);
 
      new FileType (t).createCre(t);
      
      ft.createAni(t);
      
        System.out.println( new HLMFile().onFileType(-2,-1,"hlm.hlm"));

        System.out.println("Hello World!");

    }
}
