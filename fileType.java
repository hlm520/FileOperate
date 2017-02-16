package FileDetails;

public class fileType extends fileName
{
    /**
     * 为文件创建类型
     */
    public String addType( detailListener.DetailListener dl , int type ) {
        return dl.details(type);
      }
}
