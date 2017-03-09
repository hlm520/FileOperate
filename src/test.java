
import Util.Type;
import Files.detailListener.DetailListener;
import AnalyzeFile.AnalyzeFiles;
import AnalyzeFile.test01;
import android.app.Activity;
import android.widget.LinearLayout;

public class test implements DetailListener
    {
  String content, util, contrast;
  int length, start, stop, stopCount; 
  boolean b1;

        @Override
        public String details ( int detailCode )
            {
                // TODO: Implement this method
                String detail="";
                
                switch(detailCode){
                    case path_1:
                      detail="/sdcard/ai编程/testFile/";
                        break;
                    case name_1:
                        detail="ssrc";
                        break;
                    case name_2:
                        detail="booltest";
                        break;
                    case type_1:
                        detail="txt";
                        break;
                }
                
                return detail;
            }
        
  
  public void test(){
//    String content, util, contrast;
//    int length, start, stop, stopCount; 
//    boolean b1;
//   Activity a;
//   LinearLayout l = null;
          AnalyzeFiles af = new AnalyzeFiles(this,SD,path_1,type_1);
//          AnalyzeFiles a1=new AnalyzeFiles(content,util,contrast,b1);
//          AnalyzeFiles a2=new AnalyzeFiles(length,start,stop,stopCount);
      
//          String str ="hhh"+"\n";
//          System.out.println(str);
//          testTogether t = new testTogether(this,SD,path_1,type_1);
//          t.AnalyzeFile_text(this,name_2);
//          new AnalyzeFiles(this,name_1).contrastDivide("<text>",a1,a2);
          new test01(this,SD,path_1,type_1).text(this,name_1);
//          af.Analyze_text(this,name_1);
//          af.Analyze_text(this,name_2);
//          af.Analyze_bool(this,name_1);
//          af.Analyze_bool(this,name_2);
          
//          af.Analyze_bool(this,name_1);
      
//      af.AnalyzeFile_text(this,SD,path_1,name_1,type_1);
      
      
  }
  
}
