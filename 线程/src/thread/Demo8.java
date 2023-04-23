package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:给线程起名字
 * User: LZN
 * Date: 2023-04-19
 * Time: 14:56
 */
public class Demo8 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(true){
                System.out.println("hello thread1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1");
        t.start();
        Thread t2 = new Thread(()->{
            while(true){
                System.out.println("hello thread2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"线程2");
        t2.start();
    }
}
