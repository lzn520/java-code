/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-13
 * Time: 21:34
 */
public class TextDemo {
    //什么是泛型
    public static void fun(int a) {

    }
    public static void main(String[] args) {
        fun(10);//我们传过去的是值,那么我们可以把类型也传过去吗
    }
    //阿里的一个面试题
    public static void main3(String[] args) {
        Integer a = 100;//看装箱的valueof代码
        Integer b = 100;
        System.out.println(a==b);
        Integer c = 200;
        Integer d = 200;
        System.out.println(c==d);
    }
    //拆箱
    public static void main2(String[] args) {
           Integer val = 10;
           int a = val;//拆箱 ->引用数据类型 拆成 了基本数据类型
            System.out.println(a);
           int b = val.intValue();//显示拆箱
           System.out.println(b);
           double d = val.doubleValue();//还可以拆箱成为double类型
           System.out.println(d);
    }
    //装箱
    public static void main1(String[] args) {
        int a = 10;
      // Integer val = a;//自动装箱
        Integer val = Integer.valueOf(a);//显示装箱
        Integer val2 = new Integer(a);//显示装箱
        System.out.println(val);
    }
}
