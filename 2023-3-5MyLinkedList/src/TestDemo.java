/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-05
 * Time: 22:49
 */
public class TestDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(19);
        myLinkedList.addFirst(18);
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(11);
        myLinkedList.display();
        System.out.println("==============");
        myLinkedList.addLast(11);
        myLinkedList.display();
        System.out.println("单链表的长度是"+myLinkedList.size());
        System.out.println("==============");
        myLinkedList.addIndex(1,34);//index是从0开始的
        myLinkedList.display();
        System.out.println("==============");
        myLinkedList.remove(99);
        myLinkedList.display();
        myLinkedList.removeAllKey(11);
        myLinkedList.display();




    }
}
