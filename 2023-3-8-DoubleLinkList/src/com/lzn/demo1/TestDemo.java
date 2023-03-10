package com.lzn.demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-09
 * Time: 23:09
 */
public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.display();
        System.out.println(myLinkedList.contains(13));
        myLinkedList.removeAllKey(1);
        myLinkedList.display();




    }
}
