package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:写法三：就是上面两个写法的翻版，使用了匿名内部类
 * User: LZN
 * Date: 2023-04-19
 * Time: 14:13
 */
public class Demo4 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override//写作匿名内部类的形式，也就是用一次就拉倒
            public void run() {
                System.out.println("hello");
            }
        };
        t.start();

    }
}
