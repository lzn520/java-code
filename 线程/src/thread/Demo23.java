package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:先看一下标准库中的定时器的使用
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo23 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello timer");
            }
        },3000);//其中任务就是一段代码

        System.out.println("Main");
    }

}
