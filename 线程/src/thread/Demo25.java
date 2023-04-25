package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:java标准库中的线程池
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo25 {
    public static void main(String[] args) {
        //创建一个固定线程个数的线程池,后面的参数指定了线程的个数
        ExecutorService pool =  Executors.newFixedThreadPool(10);
        //创建一个自动扩容的线程池
        //Executors.newCachedThreadPool();
        //创建一个只有一个线程的线程池
        //Executors.newSingleThreadExecutor();
        //创建一个带有定时器功能的线程池,类似于Timer
        //Executors.newScheduledThreadPool();
        for (int i = 0; i <100 ; i++) {
            //加入任务
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello threadPool");
                }
            });
        }

    }
}
