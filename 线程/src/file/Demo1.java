package file;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description:演示一下文件相关类File的构造
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //通过绝对路径来定位
        File f = new File("d:/test.txt");
        System.out.println(f.getParent());//获取到文件的父目录
        System.out.println(f.getName());//获取到文件名
        System.out.println(f.getPath());//获取到文件路径(构造File的时候指定的路径)
        System.out.println(f.getAbsoluteFile());//获取到绝对路径
        System.out.println(f.getCanonicalPath());//获取到绝对路径

        System.out.println("=====================");
        //通过相对路径来找
        File f2 = new File("./text.txt");
        System.out.println(f2.getParent());//获取到文件的父目录
        System.out.println(f2.getName());//获取到文件名
        System.out.println(f2.getPath());//获取到文件路径(构造File的时候指定的路径)
        System.out.println(f2.getAbsoluteFile());//获取到绝对路径
        System.out.println(f2.getCanonicalPath());//获取到绝对路径

    }
}
