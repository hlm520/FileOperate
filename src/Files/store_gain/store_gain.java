package Files.store_gain;
import Files.ExceptionFile.filePathException;
import Files.FileDetails.FileDetails;
import RequestCode.Codes.Codes;
import Files.changeDividePoint.changePoint;
import Files.detailListener.DetailListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class store_gain extends Codes
{
    FileDetails fd = new FileDetails ();
    
    public store_gain(){
      super();
    }
    
    public boolean store ( DetailListener dl , final String goal , 
                           int path , int name , int type , int content) {
      
      String truePath = new changePoint().change(goal,fd.addPath(dl,path));
      String trueName = fd.addName(dl,name);
      String trueType = fd.addType(dl,type);
      String trueContent = fd.addContent(dl,content);
      
      /* * 瀹炰緥鏂囦欢 璺緞*/
      File filedir = new File ( goal + truePath );
      
      if( (!filedir.isDirectory() ) & controlPath(goal,truePath) )
      {   /* *鍒ゆ柇鐩綍鏄惁瀛樺湪 
             *涓嶅瓨鍦ㄦ槸鍒涘缓鏂囦欢鐩綍 */
          filedir.mkdirs();
      }
      
      if(trueType == null){
         trueType = "log" ;
        }
        
        /* *鍒涘缓鐩爣鏂囦欢 */
      File file = new File( goal + truePath + trueName +"."+ trueType);
        try
          {
            
            if(!file.exists())
              {  
            file.createNewFile( );
            }
          }
        catch (IOException e)
          {}
          
         FileWriter fw = null;
         BufferedWriter bw = null;
         String finalPath = goal + truePath + trueName + "." + trueType;
         try{
             fw = new FileWriter(finalPath,true);
             // 鍒涘缓FileWriter瀵硅薄锛岀敤鏉ュ啓鍏ュ瓧绗︽祦
             bw = new BufferedWriter(fw); // 灏嗙紦鍐插鏂囦欢鐨勮緭鍑�
             bw.write(trueContent); // 鍐欏叆鏂囦欢 
             bw.flush(); // 鍒锋柊璇ユ祦鐨勭紦鍐�
             //鍏抽棴杈撳嚭娴�
             bw.close();
             fw.close();
           } catch (IOException e){
             e.printStackTrace();
             try {
                 bw.close();
                 fw.close();
               } catch (IOException e1) {    }
           }
          
       /* * 鎻愮ず鏂囦欢淇℃伅 */
       put(goal,truePath,trueName,trueType,trueContent);
       
       return true ;
    } //store<>
    
  public String gain (DetailListener dl, String goal ,
                      int path , int name , int type ){
                        
   /* */
    String truePath = new changePoint().change(goal,fd.addPath(dl,path));
    String content = "";
    String finalPath = goal + truePath+fd.addName(dl,name)+"."+fd.addType(dl,type);
    
      File file = new File(finalPath);
      try {
          InputStream instream = new FileInputStream(file); 
          if (instream != null) {
              //鑾峰彇杈撳叆娴佽繘琛岃鍙�
              InputStreamReader inputreader = new InputStreamReader(instream);
              BufferedReader buffreader = new BufferedReader(inputreader);
              String line;
              //鍒嗚璇诲彇,鐩墠鍙槸涓�琛�
              //鑻ユ湁闇�瑕侊紝鍐嶅湪line鍚庨潰鍔�+"/n"+鍗冲彲
              tst:
              while (( line = buffreader.readLine()) != null) {
                  content=content+line;
                  
                
                
                  
                          
                      }
                
//                line=line+"\n";
//                  while(( line = buffreader.readLine()) != null) {
//                      content=line;
//                  }
              //鍏抽棴鏂囦欢娴�
              instream.close();
            }
        }
      catch (java.io.FileNotFoundException e)   {    } 
      catch (IOException e)   {    }
      //杩斿洖鏂囦欢鍐呭content
//    System.out.println(content);
    return content ;
  } //gain<>
  
  
  /**
   *楠岃瘉璺緞鏍煎紡
   */
  private synchronized boolean controlPath (String goal,String con) {
    
    /* * 鍙橀噺鐢ㄤ簬瀵勫瓨閫氳璇�
       * 涔熷悓鏃剁敤浜庤繑鍥炴墽琛屾�� */
    boolean canWrite = false;
    
    /* * 妫�楠屾槸鍚﹂渶瑕佹姏鍑哄紓甯� * 濡傛灉涓嶄负0鏃舵姏鍑� */
    int contrastThrow1 = 0;
    int contrastThrow2 = 0;
    
    /* * 鑾峰彇瀛楃涓查暱搴� */
    int length = con.length() ;
    
    /* * 閬嶅巻瀛楃涓� */
    try{
    for(int i=0; i<length; i++){
      
      if(goal.equals("sdcard/")){
        
          if(con.substring(i,i+1).equals("/") ){
            //浠庡ご寮�濮嬫瘮瀵�
            contrastThrow1 ++;
            canWrite = true;
            
            notify();
            }
        }else {
          /* * win绯荤粺鎿嶄綔锛屽紓甯告椂寮傚父鎶涘嚭 */
          contrastThrow2 ++;
          canWrite = true ;
          notify();
         
          }
      }  
      /* * 濡傛灉鏄痵d鍗℃搷浣滐紝寮傚父鏃舵姏瀵瑰簲寮傚父 */
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
     * 鎻愮ず绯荤粺鏂囦欢鍏蜂綋鍐呭
     */
    private void put(String goal , String path , String name , String type , String content){
        System.out.println("\n鏂囦欢鐩綍缁撴瀯:" + "\n" );
        System.out.println("\t鎿嶄綔绯荤粺:" + goal  );
        System.out.println("\t璺緞:\t" + path );
        System.out.println("\t鏂囦欢鍚�:\t" + name );
        System.out.println("\t绫诲瀷:\t" +type );
        System.out.println("\t鍐呭:\t" +content );
    }
}
