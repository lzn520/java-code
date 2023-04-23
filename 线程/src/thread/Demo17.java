package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:wait和 notify等待和通知
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        /*System.out.println("wait 前");
        object.wait();   //这个代码在调用到wait就会阻塞,由于wait内部会做三件事,所以要搭配synchronized使用
        System.out.println("wait 后");*/
        synchronized (object){//wait哪个对象就得对哪个对象加锁
            System.out.println("wait 前");
            object.wait();
            System.out.println("wait 后");
        }
    }
}
