package detailListener;
public interface DetailListener
  {
    /* * 该变量可被引用为sdcard文件系统操作前缀 */
    final String SD = "sdcard/" ;

    /* * 该变量可被引用为win系统C盘操作前缀 */
    final String C  = "C://" ;

    /* * 该变量可被引用为win系统D盘操作前缀 */
    final String D  = "D://" ;

    /* * 该变量可被引用为win系统E盘操作前缀 */
    final String E  = "E://" ;

    /* * 该变量可被引用为win系统C盘操作前缀 */
    final String F  = "F://" ;

    /* * 接口实现方法 ，返回文件操作的基本信息
     * 在实现时请求操作信息键值
     * 返回的信息由对应的键值而定 */
    String details (int detailCode) ;

  }
