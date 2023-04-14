package com.fanxing;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-14
 * Time: 8:59
 */
class MyArray{
    public Object[] obj = new Object[3];

    public Object getPos(int pos){
        return obj[pos];
    }

    public  void setPos(int pos,Object val){
        obj[pos] = val;
    }

}
public class TextDemo {

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.setPos(0,10);
        myArray.setPos(1,"hello");
        myArray.setPos(2,10.0);
        //double a = myArray.getPos(2);//获取二下标的值,报错,原因是我根本不知道你的类型是什么
        Object d2 = myArray.getPos(2);//不报错了但是掩耳盗铃,要是错运算就死了
    }
}
