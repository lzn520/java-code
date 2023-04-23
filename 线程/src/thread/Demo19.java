package thread;
/**
 * Created with IntelliJ IDEA.
 * Description:单例模式-饿汉模式和懒汉模式(在demo20)
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
//通过Singleton这个类来实现单例模式,保证Singleton这个类只有唯一实例
//饿汉模式
class Singleton{//singleton表示单例模式的意思
    //1.使用static 创建一个实例,并且立即进行实例化.
    //这个instance对应的实例,就是该类的唯一实例
    private static Singleton instance = new Singleton();//static 表示当前属性和类相关,也就是只有一份了
    //2.为了防止程序员在其他地方不小心的new这个singleton,就可以把构造方法设置为private
    private Singleton(){}
   //3.提供一个方法让外面能够拿到这个唯一实例
    public static Singleton getInstance(){//这个方法也要设置为类方法,也就是加static,才可以通过类名直接访问
        return instance;
    }

}


public class Demo19 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

    }
}
