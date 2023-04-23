package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-19
 * Time: 13:48
 */
class MyThread2 extends Thread{
    @Override
    public void run() {
    while (true){
        System.out.println("hello thread");
        try {
            Thread.sleep(1000);//让线程休眠一段时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Thread t = new MyThread2();
        t.start();

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
