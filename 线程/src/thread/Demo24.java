package thread;

import javafx.concurrent.Task;

import java.util.PriorityQueue;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:自己创建一个定时器
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
//创建一个类,表示一个任务
class MyTask implements Comparable<MyTask>{
    //任务具体要干啥
    private Runnable runnable;
    //任务具体啥时候干,保存一下任务的毫秒级时间戳
    private long time;

    //delay是时间间隔,不是绝对的时间戳的值
    public MyTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis()+delay;
    }

    public void run(){
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    //优化1,要重写comparable方法,因为在堆中不知道到底要怎么比

    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time - o.time);//时间小的在前,时间大的在后
    }
}


class MyTimer{
    //定时器内部要能够存放多个任务
    //private PriorityQueue<MyTask> queue = new PriorityQueue<>();//这个不涉及到阻塞队列,由于我们要是多个线程都用这个,就会有阻塞,所以用下面这个
    private PriorityBlockingQueue<MyTask> queue= new PriorityBlockingQueue<>();

    //写一个schedule方法
    public void schedule(Runnable runnable,long delay){
        //将传入的东西打包放到堆里面
        MyTask task = new MyTask(runnable,delay);
        //放入堆里面
        queue.put(task);

        //优化3.每次放入一个任务都需要唤醒一下扫描线程,看堆首的任务是否时间到了,因为插入的可能要最先执行
        synchronized (locker){
            locker.notify();
        }

    }

    //线程锁
    private Object locker  = new Object();
    //需要一个线程不断地去扫描堆首的元素,是否已经到了可以执行的时间,所以在构造方法里面创建线程
   public MyTimer(){
        Thread t = new Thread(()->{
            while (true){
                try {
                    //先拿到堆首的任务
                    MyTask task = queue.take();
                    //获取系统当前时间
                    long curTime = System.currentTimeMillis();
                    //将系统时间与任务时间进行比较
                    if(curTime < task.getTime()){
                        //说明还没到时间,所以把取出来的任务塞回去
                        queue.put(task);
                        //优化2.指定一个等待时间,把这个线程锁上
                        synchronized (locker){
                            locker.wait(task.getTime() - curTime);
                        }
                    }else{
                        //时间到了,执行这个任务
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();//启动线程
    }

}
public class Demo24 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello timer");
            }
        },3000);

        System.out.println("main");
    }
}
