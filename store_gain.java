package store_gain;
import detailListener.DetailListener;
import java.io.File;
import FileDetails.FileDetails;
import RequestCode.Codes.Codes;
import java.io.IOException;
import ExceptionFile.filePathException;
import changeDividePoint.changePoint;
import org.apache.commons.logging.Log;

public class store_gain extends Codes
{
    FileDetails fd = new FileDetails ();
    public boolean store ( DetailListener dl , final String goal , 
                           int path , int name , int type) {
      
      String truePath = new changePoint().change(goal,fd.addPath(dl,path));
      String trueName = fd.addName(dl,name);
      String trueType = fd.addType(dl,type);
      
      /* * 实例文件 路径*/
      File filedir = new File ( goal + truePath );
      
      if( (!filedir.isDirectory() ) & controlPath(goal,truePath) )
      {   /* *判断目录是否存在 
             *不存在是创建文件目录 */
          filedir.mkdirs();
      }
      
      if(trueType == null){
         trueType = "log" ;
        }
        
        /* *创建目标文件 */
      File file = new File( goal + truePath + fd.addName(dl, name) +"."+ trueType);
        try
          {
            
            if(!file.exists())
              {  
            file.createNewFile( );
            }
          }
        catch (IOException e)
          {}
       /* * 提示文件信息 */
       put(goal,truePath,trueName,trueType);
       
       return true ;
    } //store<>
    
  public String gain (DetailListener dl, String goal ,
                      int path , int name , int type ){
                        
   /* */
    String truePath = new changePoint().change(goal,fd.addPath(dl,path));
    String content = null ;
    
    return content ;
  } //gain<>
  
  
  /**
   *验证路径格式
   */
  private synchronized boolean controlPath (String goal,String con) {
    
    /* * 变量用于寄存通行证
       * 也同时用于返回执行态 */
    boolean canWrite = false;
    
    /* * 检验是否需要抛出异常 * 如果不为0时抛出 */
    int contrastThrow1 = 0;
    int contrastThrow2 = 0;
    
    /* * 获取字符串长度 */
    int length = con.length() ;
    
    /* * 遍历字符串 */
    try{
    for(int i=0; i<length; i++){
      
      if(goal.equals("sdcard/")){
        
          if(con.substring(i,i+1).equals("/") ){
            //从头开始比对
            contrastThrow1 ++;
            canWrite = true;
            
            notify();
            }
        }else {
          /* * win系统操作，异常时异常抛出 */
          contrastThrow2 ++;
          canWrite = true ;
          notify();
         
          }
      }  
      /* * 如果是sd卡操作，异常时抛对应异常 */
      if(contrastThrow1 <0 ){
        
        throw new filePathException(goal,con);
        
          }
        if(contrastThrow2 <0){

            throw new filePathException(goal,con);

          }
          
       }catch(filePathException f)
       {    }
     
    notify();
    return canWrite ;
    
    } //controlPath<>
   
    /**
     * 提示系统文件具体内容
     */
    private void put(String goal , String path , String name , String type){
        System.out.println("\n文件目录结构:" + "\n" );
        System.out.println("\t操作系统:" + goal  );
        System.out.println("\t路径:\t" + path );
        System.out.println("\t文件名:\t" + name );
        System.out.println("\t类型:\t" +type );
    }
}
