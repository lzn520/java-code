package com.lzn.demo6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-17
 * Time: 18:18
 */
public class Test {
    public static void walk(IJumping iJumping) {
        iJumping.jump();
    }
    public static void main(String[] args) {
        Cat cat =  new Cat("大大");
        Frog frog = new Frog("小小");
        walk(cat);
        walk(frog);
        walk(new Robot());
    }
}
