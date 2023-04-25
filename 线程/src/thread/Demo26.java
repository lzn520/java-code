package thread;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:自己实现一个线程池
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */

class MyThreadPool{
    //1.描述一个任务,直接使用Runnable
    //2.使用一个数据结构来组织若干任务,使用阻塞队列
    private BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
    //3.描述一个线程,工作线程的功能就是从任务队列中取任务,再执行
    static class Worker extends Thread{
        //当前线程池中有若干个worker线程,这些线程内部都持有了上述的任务队列
        private  BlockingDeque<Runnable> queue = null;
        //通过构造方法传入
        public Worker(BlockingDeque<Runnable> queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            //就需要能够拿到上面的队列
            while (true){
                try {
                    //循环获取任务队列中的任务
                    //这里如果队列为空,取不到任务就直接阻塞
                    Runnable runnable =  queue.take();
                    //获取到之后,就去执行任务
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //4.创建一个数据结构来组织若干个线程
    private List<Thread> workers = new ArrayList<>();

    public MyThreadPool(int n){
        //在构造方法中,创建出多个线程,放到上面的数组中
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker(queue);
            //启动线程
            worker.start();
            //放入线程到数组中
            workers.add(worker);
        }
    }
    //5.创建一个方法,能够允许程序员来放任务到线程池中
    public void submit(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class Demo26 {

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(10);
        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello myThreadPool");
                }
            });
        }
    }
}
