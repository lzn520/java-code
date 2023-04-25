package thread;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:Semaphore二元信号量
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo30 {
    public static void main(String[] args) throws InterruptedException {
        //初始化的值表示可用资源有四个
        Semaphore semaphore = new Semaphore(4);
        //申请资源,P操作
        semaphore.acquire(2);
        //释放资源.V操作
        semaphore.release();
    }
}
