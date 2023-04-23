package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:线程中断的第二种方法
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo11 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("收尾工作");//中断之前做一些收尾工作
                    //触发异常之后要立刻退出循环
                    break;
                }
            }
        });
        t.start();//开始线程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //在主线程中,调用interrupt方法，来中断这个线程
        //t.interrupt的意思是让t线程被中断
        t.interrupt();
    }
}
