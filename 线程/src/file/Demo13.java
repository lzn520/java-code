package file;

import sun.awt.windows.WBufferStrategy;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:文件操作案例:完成一个文件的复制,需要用户指定两个文件路径,一个是原路径(被复制的文件),一个是目标路径(复制之后生成的文件)
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo13 {
    public static void main(String[] args) {
        //1.输入两个路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源路径: ");
        String src = scanner.next();
        System.out.println("请输入目标路径: ");
        String dir = scanner.next();
        File srcFile = new File(src);
        if(!srcFile.isFile()){
            //如果原路径不是一个文件,那么提示输入错误
            System.out.println("源路径输入有误!");
            return;
        }
        //此处不太需要去检查目标文件是否存在,因为OutputStream在写文件的时候能够自动创建不存在的文件
        //2.读取源文件,拷贝到目标文件中
        try(InputStream inputStream = new FileInputStream(src)) {
                try(OutputStream outputStream = new FileOutputStream(dir)){
                    //将源文件的东西读出来
                    while(true){
                        byte[] buffer = new byte[1024];
                        int len = inputStream.read(buffer);
                        if(len == -1){
                            //表示读取完毕
                            break;
                        }
                      //  将读出来的东西写入目标路径
                        outputStream.write(buffer,0,len);
                        System.out.println("拷贝成功");

                    }

                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
