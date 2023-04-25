package file;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:演示一下文件相关类File的操作,创建目录
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo5 {
    public static void main(String[] args) {
        File f = new File("./aaa");
        f.mkdir();//创建目录使用mkdir只能创建一级目录,多级目录创建要用    f.mkdirs()
        System.out.println(f.isDirectory());


        File f2 = new File("./aaa/bbb/ccc");
        //创建多级目录
        f2.mkdirs();
        System.out.println(f.isDirectory());


    }
}
