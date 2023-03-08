/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-05
 * Time: 22:49
 */
public class TestDemo {
    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的

    public static LinkNode mergeTwoLists(LinkNode headA, LinkNode headB) {
        if(headA == null || headB == null){
            return headA == null? headB:headA;//判断是否有空链表
        }
        LinkNode temp = new LinkNode(-1);
        LinkNode tail = temp;

        //当两个链表都没有走到尾巴的时候
        while(headA != null && headB != null){
            if(headB.val < headA.val){
                tail.next = headB;
                tail = headB;
                headB = headB.next;
            }else{
                tail.next = headA;
                tail = headA;
                headA = headA.next;
            }
        }
        //其中有一个链表走到尾巴了
        if(headA == null){
            tail.next = headB;
        }
        if(headB == null){
            tail.next = headA;
        }

        return temp.next;
    }

    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public static LinkNode partition(LinkNode head, int x) {
        // write code here
        //弄两个傀儡节点
        LinkNode af = new LinkNode(-1);
        LinkNode ae =af;
        LinkNode bf = new LinkNode(-1);
        LinkNode be = bf;
        //当链表没走到尾巴的时候将其分配到两个阵营
        while(head !=  null){
            if(head.val < x){
                ae.next = head;
                ae = ae.next;
                head = head.next;
            }else{
                be.next = head;
                be = be.next;
                head = head.next;
            }
        }
        //先让两个阵营的尾巴置为空
        ae.next = null;
        be.next = null;
        //连接两个阵营
        if(af.next == null){
            return bf.next;
        }
        if(bf.next == null){
            return af.next;
        }
        ae.next = bf.next;
        return af.next;

    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList myLinkedList2 = new MyLinkedList();

        myLinkedList.addFirst(11);
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(19);
        myLinkedList.addFirst(18);
        myLinkedList.addFirst(12);
        myLinkedList.display();
        System.out.println("==============");
        myLinkedList2.addFirst(19);
        myLinkedList2.addFirst(17);
        myLinkedList2.addFirst(12);
        myLinkedList2.addFirst(10);
        myLinkedList2.addFirst(9);
        myLinkedList2.addFirst(8);
        myLinkedList.display(myLinkedList2.head);

        System.out.println("==============");

      /*  LinkNode ret = mergeTwoLists(myLinkedList.head,myLinkedList2.head);*/

        LinkNode ret =  partition(myLinkedList.head,13);
        myLinkedList.display(ret);
        /*System.out.println("==============");
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
        myLinkedList.display();*/
        /*System.out.println("==============");
        LinkNode ret1 = myLinkedList.reverseList(myLinkedList.head);
        myLinkedList.display(ret1);*/
        /*System.out.println("==============");
        LinkNode ret2 = myLinkedList.middleNode(myLinkedList.head);
        System.out.println(ret2.val);*/



    }
}
