package AnalyzeFile;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import AnalyzeFile.Images.addImage;
import android.app.Activity;
import android.widget.LinearLayout;

public class Divide
 {

  private int IS;// 控制代码执行片段

  InputStream ips;//图片输入流
  
  Activity Activity;
  
  LinearLayout linearLayout;
  
  String text="<text>";

  int time=0;

  boolean bool=false;

  String retparam="";

  String SrcPath="";

  boolean b=false;

  int X,Y;
  
// public Divide(Activity a,LinearLayout l){
//  Activity=a;
//  linearLayout=l;
//  }
 
 /**
  * 分解标签
  * 提取标签对应内容
  */
 public final String contrastDivide(String label,String content,String util,String contrast,int length,int start,int stop,int stopCount,boolean b1)
 {
  
  
 
  if(contrast.equals(label)){
  
    for(int i2=start;i2<= length;i2++){
      if(i2+1<=length){
       
        if(util.substring(i2,i2+1).equals("$")&&stopCount==0){

          b1=true;

          stop=i2;

          stopCount=1;
         }
       }
     }

    if(b1){
      System.out.println("原内容:"+content +"\n长度为:"+length);

      retparam=content.substring(start+6,stop);

      util    =content.substring(stop+1,length);

      content =content.substring(stop+1,length);

      length  = util.length();

      b1=false;
      
      System.out.println("最终参数:"+retparam+"\n"+"此时剩余内容长度:"+length+"\n"+"截止值:"+stop);

      stopCount=0;
      start=0;
      stop =0;
      
     }
     
    if(contrast.equals("<text>")) {
     IS=1;
     text=retparam;
     run(text,time,b,SrcPath);
    }else if(contrast.equals("<time>")){
     time=Integer.parseInt(retparam);
     IS=2;
     run(text,time,b,SrcPath);
    }else if(contrast.equals("<bool>")){
     if(retparam.equals("T")) bool=true;
     else if(retparam.equals("F")) bool=false;
     IS=3;
      run(text,time,b,SrcPath);
     }else if(contrast.equals("<ssrc>")){
      SrcPath=retparam;
      IS=4;
      run(text,time,b,SrcPath);
      }else if(contrast.equals("<poiX>")){
       X=Integer.parseInt(retparam);
     }else if(contrast.equals("<poiY>")){
       Y=Integer.parseInt(retparam);
     }
   }
  return retparam;
 }
 
 private void run(String text,int time,boolean b,String SrcPath){
  switch(IS){
   case 1:
    System.out.println(text);
    break;
   case 2:
     try{
       Thread.sleep(time);
      }
     catch(InterruptedException e){}
     break;
   case 3:
    
    break;
    
   case 4:
    File file=new File(SrcPath);
     try{
       ips=new FileInputStream(file);
      }
     catch(FileNotFoundException e){}
     Bitmap bb= new BitmapFactory().decodeStream(ips);
     
     new addImage().addImage(Activity,linearLayout,bb,time,X,Y);
     
       System.out.println(bb.createBitmap(bb));
      
     break;
   }
 }
}
