/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-15
 * Time: 23:07
 */
package com.lzn.demo2;

public class Test2 {
    public static void show(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
       Flower flower = new Flower();
       Circle circle = new Circle();
       Triangle triangle = new Triangle();
       show(flower);
       show(circle);
       show(triangle);
    }
}
