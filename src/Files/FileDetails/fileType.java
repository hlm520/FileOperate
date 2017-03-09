package Files.FileDetails;

public class fileType extends fileName
{
    /**
     * 为文件创建类型
     */
    public String addType( Files.detailListener.DetailListener dl , int type ) {
        return dl.details(type);
      }
}
