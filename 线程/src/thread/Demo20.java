package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:单例模式-饿汉模式和懒汉模式
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
//懒汉模式
class Singleton2{
    //1.就不是立即初始化实例了
    private static volatile Singleton2 instance = null;//加上volatile才是完全体的线程安全单例模式
    //2.把构造方法设置为private
    private Singleton2(){}
    //3.提供一个方法来获取到上述单例的实例
    //只有当我们真正需要用到这个实例的时候也,才会真正去创建这个实例
    public static  Singleton2 getInstance(){
        //如何解决线程安全问题呢?用synchronized进行加锁,将不是原子的操作打包在一起
        //使用类对象作为锁对象,类对象在程序中只有一份,所以可以保证多个线程调用getInstance都是针对同一个对象加锁的
        //但是每次调用都加锁,就可能会产生锁竞争,所以套上一层if(instance == null)的判断
        //如果这个条件成立,说明当前单例是未初始化的,存在线程安全风险,就需要加锁~~
       if(instance == null){
           synchronized (Singleton2.class){
               if(instance == null){//存在线程安全问题,包含了读和写,不是原子的
                   instance = new Singleton2();
               }
           }
       }
        return instance;
    }
}
public class Demo20 {
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
    }
}
