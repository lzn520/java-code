package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * Description:按照字符来读
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo10 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("d:/text.txt")) {

             while(true){
                 char[] buffer = new char[1024];
                 int len = reader.read(buffer);
                 if (len == -1){
                     break;
                 }
                 for (int i = 0; i < len; i++) {
                     System.out.println(buffer[i]);
                 }

                 //也可以直接打印一个字符串,如果传入的是byte数组还可以指定一下utf-8避免乱码
                 String s = new String(buffer,0,len);
                 System.out.println(s);
             }
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
