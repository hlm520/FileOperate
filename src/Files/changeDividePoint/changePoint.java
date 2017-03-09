package Files.changeDividePoint;
import java.util.Scanner;

public class changePoint
{
    /**
     * 将路径转换为对应的正确格式
     */
    public String change ( String goal , String path ) {
      
      int length = path.length(); //路径的长度
      
      String current = "" ; //当前完成比对的字符串
      
      String defaultMark1 = ","; //默认输入的分隔符
      String defaultMark2 = "，";
      
      String mark = "/" ; //SD卡的路径分隔符
      
      for( int i=0 ; i<length ; i++){
        
        String get = path.substring(i,i+1);
        
          if( (get.equals(defaultMark1) | get.equals(defaultMark2) ) & goal.equals("sdcard/")){
          
          current = current + mark ;
          
          }else if( (! get.equals(defaultMark1) | !get.equals(defaultMark2) ) & goal.equals("sdcard/")){
          
          current = current + get ;
          
          }else if( ( get.equals(defaultMark1) | get.equals(defaultMark2) ) & goal.equals("C://")){
      
            current = current + mark + mark ;

          }else if( (!get.equals(defaultMark1) | ! get.equals(defaultMark2) ) &  goal.equals("C://")) {

            current = current + get ;
            
            }else if( (get.equals(defaultMark1) | get.equals(defaultMark2) ) & goal.equals("D://")){

              current = current + mark + mark ;

            }else if( (!get.equals(defaultMark1) | ! get.equals(defaultMark2) ) &  goal.equals("D://")) {

              current = current + get ;
              
            }else if( (get.equals(defaultMark1) | get.equals(defaultMark2) ) & goal.equals("E://")){

              current = current + mark + mark ;

            }else if( (!get.equals(defaultMark1) | ! get.equals(defaultMark2) ) &  goal.equals("E://")) {

              current = current + get ;

            }
       }
       
       if (goal.equals("sdcard/")){
         current += "/" ;
       }else { 
         current += "//" ;
       }
      
      return current ;
      
    }
    
}
