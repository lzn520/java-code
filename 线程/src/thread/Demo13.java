package thread;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:通过Tread.currentThread()获取到当前线程的引用
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo13 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
               // System.out.println(Thread.currentThread().getName());
                //还可以用this，因为重写了run，但是runnable不可以这样，因为这里的this指向的是Thread
                System.out.println(this.getName());
            }
        };
        t.start();

        //这个操作是在main线程中调用的，因此拿到的是main线程的实例
        System.out.println(Thread.currentThread().getName());
    }

}
