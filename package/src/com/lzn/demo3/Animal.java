package com.lzn.demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-15
 * Time: 23:34
 */
public class Animal {
   protected String name;
   protected int age;
    Animal(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println(name + "正在eat()");
    }
}
