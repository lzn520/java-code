package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-19
 * Time: 14:17
 */
public class Demo5 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {//和上一个没差别
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        t.start();
    }
}
