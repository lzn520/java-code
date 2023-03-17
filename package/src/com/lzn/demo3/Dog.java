package com.lzn.demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-15
 * Time: 23:28
 */
public class Dog extends Animal{

    public Dog(String name, int age){
        super(name, age);
    }
    public void eat(){
        System.out.println(name + "狼吞虎咽的eat()");
    }
    public void func(int x){
        System.out.println("int");
    }
    public void func(int x,int y){
        System.out.println("int,int ");
    }
    public void func(int x,int y,int z){
        System.out.println("int,int,int ");
    }
}
