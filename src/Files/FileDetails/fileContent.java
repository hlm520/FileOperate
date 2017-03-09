package Files.FileDetails;

public class fileContent extends fileType
{
    /**
     * 为文件创建内容
     */
    public String addContent( Files.detailListener.DetailListener dl , int content ) {
        return dl.details(content);
      }
}
