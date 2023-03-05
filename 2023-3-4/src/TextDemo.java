import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-04
 * Time: 18:14
 */

/*
class People{
    //普通成员变量-属于对象的
    public String name="heh";
    //静态成员变量-属于类的-不需要对象就可以调用
    public static int age=19;

    //使用封装，变得安全

    private String myName;
    private int myAge;

    public void setName(String myName){
        this.myName=myName;
    }
    public String getName(){
        return myName;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}'+"age="+age;
    }
}
public class TextDemo {
    public static void main(String[] args) {
        //封装
        People people = new People();
        people.setName("雷昭妮");
        System.out.println(people.getName());
        people.setMyAge(199);
        System.out.println(people.getMyAge());

    }
    public static void main1(String[] args) {
        People people = new People();
        people.name="nini";
        People.age=10;
        System.out.println(people.toString());
    }

}
*/
/*class People{
   private static int age=19;

    {
        System.out.println("这是实例代码块");
    }

    static{
        System.out.println("这是静态代码块");
    }

   //默认构造函数
    public People(){
        this.age=29;
        System.out.println("这是调用了不带参数的构造函数");
    }
    //带一个参数的构造函数
    public People(int age){
        this.age=age;
        System.out.println("这是调用了带1参数的构造函数");
    }

}*/

/*
    //编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘除四种运算.
    class Calculator{
        private int num1;
        private int num2;

       public void setNum(int num1,int num2){
           this.num1=num1;
           this.num2=num2;
       }
       //add
        public int getAdd(){
           return num1+num2;
       }
       //sub
       public int getSub(){
        return num1-num2;
       }
       //mcl
       public int getMcl(){
           return num1*num2;
       }
       //div
       public double getDiv(){
           return num1*1.0/num2;
       }
}

class MyValue{
      public int num;
}
public class TextDemo {
     public static void swap(MyValue myVal1,MyValue myVal2){
         int temp = myVal1.num;
         myVal1.num = myVal2.num;
         myVal2.num = temp;
     }

    public static void main(String[] args) {
        //实现交换两个变量的值。要求：需要交换实参的值。
        MyValue myValue1 = new MyValue();
        MyValue myValue2 = new MyValue();
        myValue1.num=10;
        myValue2.num=20;
        System.out.println("交换前");
        System.out.println("myValue1.num="+myValue1.num+" "+"myValue2.num="+myValue1.num);
        swap(myValue1,myValue2);
        System.out.println("交换后");
        System.out.println("myValue1.num="+myValue1.num+" "+"myValue2.num="+myValue1.num);

    }
    public static void main2(String[] args) {
        //编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘除四种运算.
        Calculator Calculator=new Calculator();
        Calculator.setNum(10,5);
        System.out.println(Calculator.getAdd());
        System.out.println(Calculator.getSub());
        System.out.println(Calculator.getMcl());
        System.out.println(Calculator.getDiv());

    }
   */
/* public static void main1(String[] args) {
      //调用不带参数的构造函数，如果程序没有系统会提供一个不带参数的构造函数
      People people = new People();
        System.out.println("========================");
      People people2 = new People();
    }*//*

}
*/
class sturctClass{

    sturctClass(){
        System.out.println("这是不带参数的构造方法");
    }
    sturctClass(int age){
        System.out.println("这是不带1个参数的构造方法");
    }
    sturctClass(int age,String name){
        System.out.println("这是不带2个参数的构造方法");
    }
}
public class TextDemo {
    public static void main(String[] args) {
        sturctClass sturctClass = new sturctClass();
        sturctClass sturctClass2 = new sturctClass(10);
        sturctClass sturctClass3 = new sturctClass(10,"nini");
    }
}
