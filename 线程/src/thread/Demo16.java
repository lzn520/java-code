package thread;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:由于内存可见性，编译器的优化导致的bug
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */

public class Demo16 {
    public static volatile int isQuit = 0;//volatile不保证原子性，但是能够保存内存可见性
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(isQuit == 0){
                //一个在一直读
            }
            System.out.println("循环结束！ t线程退出！");
        });
        t.start();
        //一个在合适时机写
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入一个isQuit的值：");
        isQuit = scanner.nextInt();
        System.out.println("main线程执行完毕！");
    }
}
