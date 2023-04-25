package file;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:演示一下文件相关类File的操作,文件删除
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo4 {
    public static void main(String[] args) {
        File f = new File("./text.txt");
        f.delete();
    }
}
