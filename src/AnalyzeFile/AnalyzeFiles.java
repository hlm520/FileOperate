package AnalyzeFile;

import Files.store_gain.store_gain;
import Files.detailListener.DetailListener;
import android.widget.ImageView;

public class AnalyzeFiles 
{
  String _goal = "SD";
  int _path=101;
  int _type=301;

 public AnalyzeFiles(DetailListener dl,int name){
  
   content = new store_gain().gain(dl,_goal,_path,name,_type);
 }
  store_gain sg = new store_gain();

  private String fileContents = null;

  /** 创建实例时初始化文件路径 */
  public AnalyzeFiles(DetailListener dl , 
                      String goal ,
                      int path , 
                      int type)
   {
    this._goal=goal;
    this._path=path;
    this._type=type;
   }
   
  String content, util, contrast;
  int length, start, stop, stopCount; 
  boolean b1;
  
  public AnalyzeFiles(String content,String util,String contrast,boolean b1)
   {
    this.content=content;
    this.util=util;
    this.contrast=contrast;
    this.b1=b1;
    }
    
  public AnalyzeFiles(int length,int start,int stop,int stopCount)
  {
   this.length=length;
   this.start=start;
   this.stop=stop;
   this.stopCount=stopCount;
  }
  
  int is;
  
  public final String contrastDivide(String label,AnalyzeFiles a1,AnalyzeFiles a2)
   {

    String text="<text>";

    int time=0;

    String retparam="";
    
    util = content;

    int length=util.length();

    for(int i1 = 0 ; i1<=length; i1++)
     {

      if(i1+6<length) contrast=content.substring(i1,i1+6);
      

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
        is=1;
        text=retparam;
        run(text,time);
       }else if(contrast.equals("<time>")){
        time=Integer.parseInt(retparam);
        is=2;
        run(text,time);
       }
     }
     }
    return retparam;
   }

  private void run(String text,int time){
    switch(is){
      case 1:
       System.out.println(text);
       break;
      case 2:
       try{
         Thread.sleep(time);
        }
       catch(InterruptedException e){}
     }
   }
  
}
