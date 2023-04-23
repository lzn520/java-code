package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:实现自己的一个阻塞队列,实现生产者消费者模型
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
//队列可以基于数组实现,也可以基于链表实现,此处基于数组实现阻塞队列更简单,循环队列~
class MyBlockingQueue{
    //假设这个队列里面存的是int类型
    private int [] data = new int[1000];
    //有效元素个数
    private int size = 0 ;
    //队首下标
    private int head = 0 ;
    //队尾下标
    private int tail = 0 ;

    //通过一个专门的锁对象来加锁,也可以直接在方法外面加锁,因为里面的元素都是在操作公共元素,或者synchronized(this)来加锁
    private  Object locker = new Object();
    //入队列
    public void put(int value) throws InterruptedException {
        synchronized(locker){
            if(size == data.length){
                //队列满了直接返回
                //  return;
                locker.wait();//针对哪个对象加锁,就使用哪个对象wait
            }
            //队列不满直接插入
            data[tail] = value;
            tail++;
            //处理tail到达末尾的情况
            if(tail >= data.length){
                tail = 0;
            }
            size++;//勿忘
            //队列不空,则唤醒take中的等待
            locker.notify();
        }

    }
    //出队列
    //使用Integer主要是为了能返回非法值
   public Integer take() throws InterruptedException {
       synchronized(locker){
           if(size == 0){
               //队列里面没有元素,返回一个非法值

              // return null;
               locker.wait();
           }
           //取出head位置的元素
           int ret = data[head];
           head++;
           //处理head到达末尾的情况
           if(head >= data.length){
               head = 0;
           }
           size--;
           //take 成功之后就唤醒put中的等待
           locker.notify();
           return ret;
       }

    }


}

public class Demo22 {
    private static MyBlockingQueue queue = new MyBlockingQueue();
    public static void main(String[] args) {
        //实现一个简单的生产者消费者模型
        Thread producer = new Thread(()->{
            int num = 0;
            while(true){
                try {
                    System.out.println("生产了: "+num);
                    queue.put(num);
                    num++;
                    //当生产者生产的慢一些的时候,消费者就得跟着生产者的步伐走
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();

        Thread customer = new Thread(()->{
            while(true){
                int ret = 0;
                try {
                    ret = queue.take();
                    System.out.println("消费了: " +ret);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();




       /* //先简单验证一下这个队列能否正确工作
        MyBlockingQueue queue = new MyBlockingQueue();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        int ret = 0;
        ret = queue.take();
        System.out.println(ret);
        ret = queue.take();
        System.out.println(ret);
        ret = queue.take();
        System.out.println(ret);*/

    }
}
