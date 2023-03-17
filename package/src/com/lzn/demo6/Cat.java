package com.lzn.demo6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-17
 * Time: 18:18
 */
public class Cat extends Animal implements IJumping,IRunning{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void jump() {
        System.out.println(this.name + "猫咪正在欢快的跳");
    }

    @Override
    public void run() {
        System.out.println(this.name + "猫咪正在焦急的跑");
    }
}
