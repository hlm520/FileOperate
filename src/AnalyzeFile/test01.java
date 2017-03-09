package AnalyzeFile;
import Files.store_gain.store_gain;
import Files.detailListener.DetailListener;
import android.app.Activity;
import android.widget.LinearLayout;
//import android.jar.android.widget.ImageView;
//import store_gain.store_gain;
public class test01 
{
 
  String _goal = "";

  int _path=0;

  int _type=0;

  public test01(DetailListener dl , String goal ,
                      int path , int type)
   {
    this._goal=goal;
    this._path=path;
    this._type=type;
   }
   
 String retparam="";
 
 String content="";
 
 String util="";
 
 String contrast="";
 
 int start=0;
 
 int stop =0;
 
 int stopCount=0;
 
 boolean b1=false;
 
 public void text(DetailListener dl,int name){
  
  content = new store_gain().gain(dl,_goal,_path,name,_type);
  
  util = content;
  
  int length=util.length();
  
  System.out.println(content);
  
  for(int i1 = 0 ; i1<=length; i1++)
  {
   
   if(i1+6<length) contrast=content.substring(i1,i1+6);
   
   if(contrast.equals("<text>")){
    
     new Divide().contrastDivide("<text>",content,util,contrast,length,i1,stop,stopCount,b1);
     
    }else if(contrast.equals("<bool>")){
//     
//      new Divide(this,LinearLayout).contrastDivide("<bool>",content,util,contrast,length,i1,stop,stopCount,b1);
//
//     }else if(contrast.equals("<view>")){
//      
//       new Divide(this,LinearLayout).contrastDivide("<view>",content,util,contrast,length,i1,stop,stopCount,b1);
//
//     }else if(contrast.equals("<time>")){
//
//       new Divide(this,LinearLayout).contrastDivide("<time>",content,util,contrast,length,i1,stop,stopCount,b1);
//
//     }else if(contrast.equals("<para>")){
//
//       new Divide(this,LinearLayout).contrastDivide("<para>",content,util,contrast,length,i1,stop,stopCount,b1);
//
     }else if(contrast.equals("<ssrc>")){

       new Divide().contrastDivide("<ssrc>",content,util,contrast,length,i1,stop,stopCount,b1);

     }else if(contrast.equals("<poin>")){

       new Divide().contrastDivide("<poin>",content,util,contrast,length,i1,stop,stopCount,b1);

      }
    }
  }
}
