package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:19
 */
public class Demo9 {
    public static boolean isQuit = false;
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(!isQuit){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        //只要把这个isQuit设置为true，此时这个循环就推出了，进一步的run就执行完了，再进一步就是线程执行结束了。
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isQuit = true;
        System.out.println("线程结束");
    }
}
