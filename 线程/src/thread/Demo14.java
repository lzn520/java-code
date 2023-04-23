package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:线程状态
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo14 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
             while(true){
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

        });
       // System.out.println(t.getState());//获取到t的状态，在start之前调用state，获取到的是new
        t.start();
        try {
            Thread.sleep(1000);//休息一秒再看状态，因为不知道是main线程先执行还是t
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
