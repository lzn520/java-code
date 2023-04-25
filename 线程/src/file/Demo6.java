package file;

import java.io.File;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:演示一下文件相关类File的操作,返回File对象代表的目录下的文件名
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo6 {
    public static void main(String[] args) {
        File f = new File("./aaa");
        System.out.println(Arrays.toString(f.list()));//直接打出来是一段地址,要用toString
    }
}
