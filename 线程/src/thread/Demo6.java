package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:使用lambda代替了Runnable而已
 * User: LZN
 * Date: 2023-04-19
 * Time: 14:21
 */
public class Demo6 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        t.start();
    }
}
