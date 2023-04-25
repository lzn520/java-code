package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:CAS原子类
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo27 {
    public static void main(String[] args) throws InterruptedException {
        //创建了一个num其初始值为0,这个num就是原子的
        AtomicInteger num = new AtomicInteger(0);
        //用多线程对其进行累加
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                //这个方法相当于num++
                num.getAndIncrement();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                //这个方法相当于num++
                num.getAndIncrement();
            }
        });

        /*//--num
        num.decrementAndGet();
        //++num
        num.incrementAndGet();
        //num--
        num.getAndDecrement();
        //+= 10
        num.getAndAdd(10);*/

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //通过get方法得到原子类内部的值
        System.out.println(num.get());
        //我们会发现结果是线程安全的
    }
}
