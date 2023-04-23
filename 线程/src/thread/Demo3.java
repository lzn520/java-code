package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:第二种创建线程的写法
 * User: LZN
 * Date: 2023-04-19
 * Time: 14:06
 */
//Runable 就是在描述一个“任务”
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("hello");
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());//通过Runnable来描述任务的内容，在进一步把描述好的任务交给Thread实例
        t.start();
    }
}
