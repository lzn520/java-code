package file;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:演示一下文件相关类File的操作,结合文件的创建和删除(在下一个demo)
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        //文件的创建和删除
        File f = new File("D:/text.txt");
        System.out.println(f.exists());
        System.out.println("创建文件");
        f.createNewFile();
        System.out.println("创建文件结束");
        System.out.println(f.exists());

    }
}
