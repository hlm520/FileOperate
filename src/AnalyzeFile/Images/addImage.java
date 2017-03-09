package AnalyzeFile.Images;
import android.widget.LinearLayout;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.app.Activity;

public class addImage
{
 public void addImage(Activity activity,LinearLayout parentLayout,Bitmap newBitMap,int times,int X,int Y)
 {
  int stop=0;
  ImageView imageView=new ImageView(activity);
  
  if(stop==0)
  parentLayout.addView(imageView);
  
  for(stop=0;stop<=times;stop++)
  {
   if(newBitMap!=null)
    {
    imageView.setImageBitmap(newBitMap);
    newBitMap=null;
    }else if(times!=0&&(X!=0|Y!=0))
    {
     imageView.setX(X);
     imageView.setY(Y);
    }
  }
 }
 
}
