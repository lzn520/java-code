package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * Description:按照字符来写
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo11 {
    public static void main(String[] args) {
        //构造的时候设置append为true就会悬挂在原有的内容后面,不会清空其他内容
        try (Writer writer = new FileWriter("d:/text.txt",true)){
            writer.write("syx");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
