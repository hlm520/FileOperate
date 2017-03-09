package Util;
import Interfaces.DefineAndDo;
import DefineFile.FileType;
import java.io.File;
import WrongException.FileSizeException;

public class HLMFile  implements DefineAndDo
  {
    
    @Override
    public String onFileType( int min, int max , String path)
      {
        // TODO: Implement this method
        
        int size = (int) hlmFile(fileString(path)).length();
      try
      {
      if(min<max){
        if(max > size & min < size)
          {
            System.out.println("file size is smaller than max and biger than min !");
            return "MediumHLM";
            }else if(min > size)
            {
            System.out.println("file size is so small !");
            return "SmallHLM";
            }else if(max < size)
            {
            System.out.println("file size is biger than max !");
            return "BigHLM";
            }
        }else { 
        throw new WrongException.FileSizeException();
        }
      }catch(WrongException.FileSizeException we){
          
        }
        return "LogHLM";
      }

      /**
       * 目前定义文件长度
       * 为int 类型长度
       * 后续优化为long 类型
       */
    @Override
    public int fileSize( File file,String filePath )
      {
        // TODO: Implement this method
        if(file.equals(hlmFile(fileString(filePath))))
        {
          return (int)file.length();
        }
        return 0;
      }

    @Override
    public boolean canDefined( FileType hlm )
      {
        // TODO: Implement this method
        return false;
      }
      
    private File hlmFile(String file)
    {
      
      return new File(file);
    }
    
    public String fileString(String filePath)
    {
      
      return filePath;
    }
    
    public String toString(int value)
    {
      String str = null;
      return str.valueOf(value);
    }
    
}
