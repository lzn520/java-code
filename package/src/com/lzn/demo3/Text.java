package com.lzn.demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-16
 * Time: 0:05
 */

public class Text {

    public static void main(String[] args) {
        Dog dog = new Dog("小小",5);
        dog.func(10);
    }

    public static Animal func(){
        Dog dog = new Dog("小小",5);
        return dog;
    }
    public static void main1(String[] args) {
        Dog dog = new Dog("小小",5);
        Animal animal = new Dog("小小",5);

    }
}
