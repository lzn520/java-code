package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:wait和 notify等待和通知
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo18 {
    private static Object Locker  = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            //这个线程里面进行wait
            synchronized (Locker){
                System.out.println("wait 之前");
                try {
                    Locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("wait 之后");
            }
        });
        t1.start();
        //让程序执行更清楚
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread  t2 = new Thread(()->{
            //进行notify
            synchronized (Locker){
                System.out.println("notify 之前");
                Locker.notify();
                System.out.println("notify 之后");
            }
        });

        t2.start();
    }
}
