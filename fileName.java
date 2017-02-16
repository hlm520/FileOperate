package FileDetails;

public class fileName extends filePath
{
    /**
     * 为文件创建文件名
     */
    public String addName( detailListener.DetailListener dl , int name ) {
        return dl.details(name);
      }
}
