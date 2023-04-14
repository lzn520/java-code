package com.fanxing;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-14
 * Time: 9:40
 */
class Alg<E extends Comparable<E>> {
    public E findMax(E[] array) {
        E max = array[0];
        for (int i = 1; i < array.length; i++) {
           /* if(max < array[i]){//由于其中有一个引用类型,所以不可以用<比较
                max = array[i];
            }*/
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }

        }

        return max;
    }
}

//有没有泛型方法ne
class Alg2{
    public <E extends Comparable<E>> E findMax(E[] array) {
        E max = array[0];
        for (int i = 1; i < array.length; i++) {
           /* if(max < array[i]){//由于其中有一个引用类型,所以不可以用<比较
                max = array[i];
            }*/
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }

        }

        return max;
    }
}
public class Textfanxing2 {
    public static void main(String[] args) {

    }
}
