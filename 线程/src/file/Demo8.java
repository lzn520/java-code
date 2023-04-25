package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:演示FileInputStream,对文件内容进行操作:打开文件,读文件,写文件,关闭文件
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo8 {
    public static void main(String[] args) {
        //构造方法中需要执行打开文件的路径.
        //这里的路径可以是绝对路径,也可以是相对路径,还可以是File对象
       /* try {
            //1.创建对象,同时也是在打开文件
            InputStream inputStream = new FileInputStream("D:/text.txt");
            //2.尝试一个一个字节的读,把整个文件读完
            while(true){
                int b = inputStream.read();
                if(b == -1){
                    //读到了文件末尾
                    break;
                }
                System.out.println(b);//打印读到的每个字节
            }
            //3.读完之后要记得关闭文件,释放资源
            inputStream.close();
         *//* } catch (FileNotFoundException e) {//这个异常是下面异常的子类,所以可以合并
            e.printStackTrace();
         } catch (IOException e) {//IO操作失败的可能性是非常非常大的,比如读着读着你把硬盘拔了
            e.printStackTrace();
         }*//*
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //在这个代码中没有显示调用Close(),当时try会帮我们自动调用,但是放在try()中的一定要实现了Closeable接口才行

        /*try(InputStream inputStream = new FileInputStream("d:/text.txt")){

            while(true){
                int b = inputStream.read();
                if(b == -1){
                    //读到了文件末尾
                    break;
                }
                System.out.println(b);//打印读到的每个字节
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try(InputStream inputStream = new FileInputStream("d:/text.txt")){

            while(true){
                //一次读取若干个字节
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if(len == -1){
                    //读取已经完成
                    break;
                }
                for (int i = 0; i < len; i++) {
                    System.out.println(buffer[i]);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
