package file;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:演示一下文件相关类File的操作
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo2 {
    public static void main(String[] args) {
        //File f = new File("d:/text.txt");
        File f = new File("./text.txt");

        System.out.println(f.exists());//判断文件是否存在
        System.out.println(f.isDirectory());//判断文件是否是目录
        System.out.println(f.isFile());//判断文件是否是普通文件
    }
}
