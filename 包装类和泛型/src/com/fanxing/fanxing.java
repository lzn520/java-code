package com.fanxing;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-14
 * Time: 9:09
 */
class MyArray2<T>{
    public T[] obj = (T[])new Object[3];//这样写是存在问题的,我们以后按照官方怎么用我们怎么用

    public T getPos(int pos){
        return obj[pos];
    }

    public  void setPos(int pos,T val){
        obj[pos] = val;
    }

}

public class fanxing {
    public static void main(String[] args) {
        //实例化对象的同时 指定当前泛型类的指定参数类型是Integer
        MyArray2<Integer> myArray = new MyArray2<Integer>();//指定的参数类型必须是引用类型
        myArray.setPos(0,10);
        myArray.setPos(1,78);
        myArray.setPos(2,66);
        int d = myArray.getPos(2);//不需要强转了
        //double a = myArray.getPos(2);//获取二下标的值,报错,原因是我根本不知道你的类型是什么
       // Object d2 = myArray.getPos(2);//不报错了但是掩耳盗铃,要是错运算就死了
        System.out.println("=========================");
        MyArray2<String> myArray2 = new MyArray2<>();//后面的可以省略
        myArray2.setPos(0,"hello");
        myArray2.setPos(1,"world");

    }
}
