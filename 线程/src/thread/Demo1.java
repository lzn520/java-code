package thread;
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:最基本的创建线程的办法
 * User: LZN
 * Date: 2023-04-19
 * Time: 13:40
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
