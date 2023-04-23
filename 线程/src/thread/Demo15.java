package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:线程不安全的案例
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
//用类来弄是为了方便加锁
class Counter{
    //这个变量就是线程要去自增的变量
    public int count;
    //线程调用这个方法来自增
    //通过synchronized来对这个方法加锁，进入方法自动加锁，离开方法自动解锁
    /*synchronized public void increase(){
        count++;
    }*/
    public void increase(){
        synchronized(this){//锁对象加锁
            count++;
        }
    }
    //把synchronized加到静态方法上,相当于对类对象加锁
    /*synchronized public static void fun(){

    }*/
    //可以写成下面这样
    public static void fun(){
        synchronized(Counter.class){//Counter.class是类对象,因为Counter是这个类的名字

        }
    }


}
public class Demo15 {
    //创建这个实例
    private  static  Counter counter = new Counter();
    public static void main(String[] args) {
        Thread t1 =  new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();
        //必须在t1和t2执行完成在打印count的结果
        //否则，main和t1，t2之间都是并发的关系,导致t1和t2还没执行完 就执行了下面的打印操作
        try {
            t1.join();//这两join谁在前谁在后都没关系
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //在main中打印一下两个线程执行完成之后的count结果
        System.out.println(counter.count);
    }
}
