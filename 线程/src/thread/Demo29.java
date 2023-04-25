package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:ReentrantLock 可重入锁
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo29 {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        //加锁
        locker.lock();
        //抛出异常了导致unlock执行不到,就会死锁
        //解锁
        locker.unlock();
    }
}
