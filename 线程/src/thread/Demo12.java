package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:线程等待
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo12 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        //在主线程中可以使用一个等待操作，来等待t线程的结束
        try {
            t.join(10000);//首先调用这个方法的线程，是main线程，针对t这个线程对象调用的，此时就是让main等待t
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
