package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:使用Callable创建线程
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo28 {
    public static void main(String[] args) {
        //其中的泛型参数代表的是返回值类型是什么.通过callable来描述一个任务
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 1000 ; i++) {//此时只是有了一个任务
                    sum += i;
                }
                return sum;
            }
        };
        //为了让线程直线callable中的任务,光使用构造方法还不够,还需要一个辅助的类
        FutureTask<Integer> task = new FutureTask<>(callable);//相当于麻辣烫中的小票
        //创建线程,来完成这里的计算工作
        Thread t = new Thread(task);
        t.start();

        //凭小票来端自己的麻辣烫
        //如果线程的任务没有执行完,get就会阻塞
        //一直阻塞到,任务完成了,结果算出来了
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
