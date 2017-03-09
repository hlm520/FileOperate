package Files.ExceptionFile;

public class filePathException extends Exception
{
    public filePathException(){
      super();
    }
    
    public filePathException(String msg){
      super(msg);
    }
    
    public filePathException(String goal,String path) {

        System.out.println("\n文件操作提示:" +"\n"+ "\t文件路径错误!"+"");
        System.out.println("\t文件保存失败@路径:" +"\n\t\t"+ path );
        if(goal.equals("sdcard/"))
          System.out.println("\t在手机系统,每个文件夹之间应该添加分隔符: ,");
        else
          System.out.println("\t在win系统,每个文件夹之间应该添加分隔符: ," +"\n" );
        return ;
      }
}
