package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-19
 * Time: 14:25
 */
public class Demo7 {
    public static  final  long count = 10_0000_0000;
    public static void serial() { //看串行执行消耗多少时间
        //记录程序执行时间.记录开始时间
        long beg = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < count ; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < count ; i++) {
            b++;
        }
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("消耗时间 = "+(end - beg) + "ms");
    }
    public static void concurrency() throws InterruptedException {//用两个线程并行实现
        //记录程序执行时间.记录开始时间
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < count ; i++) {
                a++;
            }
        });
        t1.start();
        Thread t2 = new Thread(() ->{
            long b = 0;
            for (long i = 0; i < count ; i++) {
                b++;
            }
        });
        t2.start();
        //不能在这记录结束时间，现在这个时间戳的代码是在main线程中
        //main和t1 t2之间是并发执行的关系，此处t1和t2还没有执行完毕呢，就开始记录结束时间了，显然是不准确的
        //正确的做法是让main线程等待t1和t2跑完了，再来记录结束时间。
        //join效果就是等待线程结束，t1.join就是让main线程等待t1结束。t2.join 就是让main线程等待t2结束
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("消耗时间 = "+(end - beg) + "ms");
    }

    public static void main(String[] args) throws InterruptedException {
       /* serial();*/
        concurrency();
    }
}
