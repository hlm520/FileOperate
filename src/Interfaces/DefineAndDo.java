package Interfaces;
import java.io.File;
import DefineFile.FileType;

public interface DefineAndDo
{
  /**
   * 
   */
  String onFileType(int min , int max , String path);
  
  /**
   * 
   */
  int fileSize(File file,String filePath);
  
  /**
   *
   */
  boolean canDefined(FileType hlm);
  
  /**
   *
   */
  
}
