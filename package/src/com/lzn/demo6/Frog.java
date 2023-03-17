package com.lzn.demo6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-17
 * Time: 18:21
 */
public class Frog extends Animal implements IJumping,ISwimming{
    public Frog(String name) {
        super(name);
    }

    @Override
    public void jump() {
        System.out.println(this.name + "青蛙正在一蹦一跳");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "青蛙正在游泳");
    }
}
