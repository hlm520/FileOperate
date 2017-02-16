package FileDetails;

import detailListener.DetailListener;

public class filePath
{
  /**
   * 为文件创建路径
   */
   public String addPath( DetailListener dl , int path ) {
     return dl.details(path);
   }
}
