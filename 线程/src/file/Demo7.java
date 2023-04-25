package file;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:演示一下文件相关类File的操作,重命名文件
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo7 {
    public static void main(String[] args) {
        File f1 = new File("./aaa");
        File f2 = new File("./zzz");
        f1.renameTo(f2);//把f1改成的文件名改成zzz
    }
}
