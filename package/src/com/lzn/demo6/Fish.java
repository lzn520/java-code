package com.lzn.demo6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-17
 * Time: 18:21
 */
public class Fish extends Animal implements ISwimming {

    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name + "小鱼正在欢快的游泳");
    }
}
