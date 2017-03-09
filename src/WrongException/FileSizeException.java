package WrongException;

public class FileSizeException extends Exception
{
  public FileSizeException() {
    super();
    System.out.println("Errors:\n The file size was wrongly defined :");
    System.out.println("   File's min size must smaller than max !");
    System.out.println("   at  FLMFile.onFileType(int min,int max)---String\n");
    }
}
