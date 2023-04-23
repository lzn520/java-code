package thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:用java标准库中的阻塞队列,实现一个简单的生产者消费者模型
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */

public class Demo21 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();//这就是java内置的阻塞队列
        queue.put("hello");//通过put来实现入队列操作,put会阻塞,阻塞就要唤醒,唤醒就会打断,所以要抛出异常
        String s = queue.take();//通过take来出队列

    }
}
