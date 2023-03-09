/**
 * Created with IntelliJ IDEA.
 * Description:不带头的双向链表
 * User: LZN
 * Date: 2023-03-08
 * Time: 10:40
 */
public class TextDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addFirst(2);
        myLinkedList1.addFirst(2);
        myLinkedList1.addFirst(2);
        myLinkedList1.addFirst(2);
        myLinkedList1.display();//4 3 2 1
        myLinkedList1.addLast(2);
        myLinkedList1.display();//4 3 2 1 5
        myLinkedList1.remove(2);
        myLinkedList1.display();
        myLinkedList1.removeAllKey(2);
        System.out.println("=====");
        myLinkedList1.display();
    }
}
