package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:使用字节流写文件的案例
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo9 {
    public static void main(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("d:/text.txt")) {
            outputStream.write(97);
            outputStream.write(98);
            outputStream.write(99);
            byte[] buffer = new byte[]{100,20,34};
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
