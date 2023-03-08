/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-05
 * Time: 22:50
 */
class LinkNode{
    public int val;
    public LinkNode next;

    public  LinkNode(int data){
        this.val = data;
    }
}
public class MyLinkedList {

    LinkNode head;//链表的头引用
    //头插法
    public void addFirst(int data) {
       LinkNode node = new LinkNode(data);
       if(head == null){
           head = node;
       }else{
           node.next = this.head;//关键代码，一定要先把结点内的next先处理
           this.head = node;
       }
    }

    //尾插法
    public void addLast(int data) {
        LinkNode node = new LinkNode(data);
        if( this.head == null){
            //尾插法第一次插入必须判断
            this.head = node;
        }
         else{
            LinkNode cur=this.head;
             while (cur.next != null)
             {
                 cur = cur.next;
             }
             cur.next = node;
         }
    }

    //获取index-1位置的地址
    public LinkNode findIndex(int index){
        LinkNode cur = this.head;
        while(index-1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        LinkNode node = new LinkNode(data);
        //1.当head==NUll时候头插
        if(this.head == null){
            head = node;
            return;
        }
        //2.当index=size()尾插
        if(index == size()){
            addLast(data);
        }
        //3.中间插入,先要获取到插入位置前一个节点的地址
        LinkNode cur = findIndex(index);//获取到插入位置前一个节点的地址
        node.next = cur.next;
        cur.next = node;

    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        LinkNode cur = this.head;
        while(cur != null){//当cur不为空的时候循环
            if(cur.val == key){//判断cur的val是否等于key
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //找前驱
    public LinkNode searchPre(int key){
        LinkNode cur = this.head;
        while(cur.next != null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //先要判断单链表是不是空
        if(this.head == null){
            System.out.println("单链表为空");
            return;
        }
        //当关键字出现在头节点，直接让head后移
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        //当关键字出现在中间结点
        /*LinkNode cur = this.head;
        LinkNode del = null;
        while(cur.next != null){
            if(cur.next.val == key){
                del = cur.next;
                cur.next = del.next;
                return;
            }
            cur = cur.next;
        }*/
        //打包一个找前驱的函数
        LinkNode pre = searchPre(key);
        if(pre == null){
            System.out.println("找不到该元素");
        }else{//删除找到的元素
            LinkNode cur = pre.next;
            pre.next = cur.next;
            return;
        }
        return;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if(this.head == null){//链表为空直接返回
            return;
        }
        LinkNode pre = this.head;
        LinkNode cur = pre.next;
        while(cur != null){
            if(cur.val == key){//如果cur的值等于要找的值，那么删除cur当前的结点
                pre.next = cur.next;
                cur = cur.next;
            }else{//否则两个节点都后移
                pre = cur;
                cur = cur.next;
            }
        }
        //我们发现头引用并没有处理，所以要单独处理
        if(this.head.val == key){
            this.head = this.head.next;
        }
        return;
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        LinkNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //打印单链表
    public void display() {
        LinkNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //重载打印函数
    public void display(LinkNode head) {
        LinkNode cur = head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //清空单链表
    public void clear(){
        //暴力清空，只要结点没有被引用就会自动回收
        this.head = null;
    }

    //反转链表
    public LinkNode reverseList(LinkNode head){
        //判断链表是不是空
        if(head == null){
            return null;
        }
           LinkNode temp = head;
           LinkNode cur = temp.next;
           LinkNode curNext;
           temp.next = null;//先让反转链表尾巴结点的next域置为空
           while(cur != null){
               curNext = cur.next;
               cur.next = temp;
               temp = cur;
               cur = curNext;

           }
           return temp;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    public LinkNode middleNode(LinkNode head) {
        if(head == null){
            return null;
        }
        LinkNode fast = head;
        LinkNode slow = head;
        while (fast != null && fast.next != null ){//这两个条件不可以调换，不然会出现空指针异常
            fast = fast.next.next;
            slow = slow.next;
        }
        //走到这里的时候slow对应的结点就是我们要找的结点
        return slow;
    }

    //找倒数第k个结点
    public  LinkNode FindKthToTail(LinkNode head,int k){
        if(k <= 0 ||head == null /*k > size()*/){//如何去掉k>size()这个判断呢？我们可以发现当k>size的时候fast会走到null
            return null;
        }

        LinkNode fast = head;
        LinkNode slow = head;
        //先让fast走k-1步
        while(k-1 > 0){
            fast = fast.next;
            //用下面来去掉k>size()判断
            if(fast == null){
                return null;
            }
            k--;
        }
        //然后让fast和slow一起走
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public LinkNode mergeTwoLists(LinkNode headA, LinkNode headB) {
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
   public LinkNode partition(LinkNode head, int x) {
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
       if(af.next == null){//如果没有比x小的，那么a阵营是没有东西的
           return bf.next;
       }
       if(bf.next == null){//同上理
           return af.next;
       }
       ae.next = bf.next;
       return af.next;
   }
   //7.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
   public LinkNode deleteDuplication(LinkNode head) {
        //傀儡节点
        LinkNode newHead = new LinkNode(-1);
        LinkNode temp = newHead;
        LinkNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur!= null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //多走一步
                cur = cur.next;
            }else{
                temp.next = cur;
                temp = temp.next;
                cur = cur.next;
            }
        }
        temp.next = null;
        return newHead.next;
   }
   //对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
   public boolean chkPalindrome(LinkNode head) {
        if(head == null){
            return false;
        }
       // write code here
       LinkNode fast = head;
       LinkNode slow = head;
       LinkNode cur = slow.next;
       LinkNode curNext = null;
       //1.先找到中间节点再反转
       while(fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
       }
       //slow走到了中间位置=》反转后半段
       while(cur != null){
           curNext = cur.next;
           cur.next = slow;
           slow = cur;
           cur = curNext;
       }
       //反转完成，判断回文
       while(head != slow){
           //奇数个的情况下的判断
           if(head.val != slow.val){
               return false;
           }
           //偶数个的情况下的判断
           if(head.next == slow){
               return true;
           }
           head = head.next;
           slow = slow.next;
       }
       return true;
   }

   // 输入两个链表，找出它们的第一个公共结点
   public LinkNode FindFirstCommonNode(LinkNode headA, LinkNode headB) {
         //1.先定义两个指针pl和ps，pl指向最长的，ps指向最短的
       LinkNode pl = headA;//先假设A是长的，B是短的
       LinkNode ps = headB;
       int lenA = 0;
       int lenB = 0;
       //计算A的长度
       while(pl != null){
           lenA++;
           pl = pl.next;
       }
       //走到这里pl=null了
       ps =headA;
       //计算B的长度
       while(ps != null){
           lenB++;
           ps = ps.next;
       }
       //走到这里ps = null
       int len = lenA - lenB;//差值步
       if(len < 0){//如果差值步是负数，说明A要短一些
           pl = headB;
           ps = headA;
           len = lenB - lenA;
       }

       while(len > 0){//先让长的走差值步
           pl = pl.next;
           len--;
       }
       //同时走直到相遇
       while(pl != ps){
           pl = pl.next;
           ps = ps.next;
       }

       return pl;

   }

   //给定一个链表，判断链表中是否有环
   public boolean hasCycle(LinkNode head) {
        //判空
        if(head == null){
            return false;
        }
      LinkNode fast = head;
      LinkNode slow = head;
      while(fast != null && fast.next !=null){
          fast = fast.next.next;
          slow = slow.next;
          if(fast == slow){//链表有环
              return true;
          }
      }
      //走到这说明无环
      return false;
   }

    // 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回null
    public LinkNode EntryNodeOfLoop(LinkNode head) {
        LinkNode fast = head;
        LinkNode slow = head;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        //走到这里的时候fast==slow了
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;


    }

}
