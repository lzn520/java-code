package thread;

import javax.sound.midi.Soundbank;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:CountDownLatch终点线
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo31 {
    public static void main(String[] args) throws InterruptedException {
        //构造方法的参数表示的是有几个选手参赛
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(()->{
                try {
                    Thread.sleep(3000);//为了模拟每个选手不是同时到达
                    System.out.println(Thread.currentThread().getName() + "到达终点了");
                    latch.countDown();//表示到达终点了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            t.start();
        }
        //裁判就要等待所有的线程到达
        //当这些线程没有执行完的时候,await就阻塞,所有的线程都执行完了,await才返回
        latch.await();
        System.out.println("比赛结束");
    }
}
