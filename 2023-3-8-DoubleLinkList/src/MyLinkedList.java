/**
 * Created with IntelliJ IDEA.
 * Description:双向链表
 * User: LZN
 * Date: 2023-03-08
 * Time: 11:03
 */
class LinkNode{
    public int val;
    public LinkNode next;
    public LinkNode prev;
    public LinkNode(int val){
        this.val =val;
    }

}
public class MyLinkedList {
    public LinkNode head;//指向链表头节点
    public LinkNode last;//指向链表尾部
    //头插法
    public void addFirst(int data) {
        LinkNode node = new LinkNode(data);
        //分为第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            //不是第一次插入
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        LinkNode node = new LinkNode(data);
        //分为第一次插入
        if (this.last == null) {
            this.head = node;
            this.last = node;
        } else {
            //不是第一次插入
            node.prev = this.last;
            this.last.next = node;
            this.last = node;
        }
    }
    //找到index位置的结点
    public LinkNode searchIndex(int index){

        LinkNode cur = this.head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
         return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        //和单链表的是一样的
        LinkNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //分三种 1，删除的是头 2.删除的是尾巴 3.删除的是其他
        LinkNode cur = this.head;
        while(cur != null) {
            if (cur.val == key) {
                //删除的是头
                if (cur == this.head) {
                    //要防止只有一个结点删除时候的空指针异常
                    if(cur.next == null){
                        this.head = null;
                        this.last = null;
                        return;
                    }
                    this.head = this.head.next;
                    this.head.prev = null;
                    return;
                } else if (cur == this.last) {//删除的是尾巴
                    this.last = this.last.prev;
                    this.last.next = null;
                    return;
                }
                //走到这里说明删除的非头尾
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            } else {
                cur = cur.next;//没找到就继续向后
            }
        }
        //走到这说明没有这个key
        return;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

        //分三种 1，删除的是头 2.删除的是尾巴 3.删除的是其他
        LinkNode cur = this.head;
        while(cur != null) {
            if (cur.val == key) {
                //删除的是头
                if (cur == this.head) {
                    //要防止只有一个结点删除时候的空指针异常
                    if(cur.next == null){
                        this.head = null;
                        this.last = null;
                    }else {
                        this.head = this.head.next;
                        this.head.prev = null;
                    }

                } else if (cur == this.last) {//删除的是尾巴
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    //走到这里说明删除的非头尾
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
                cur = cur.next;//没找到就继续向后

        }
    }
    //得到单链表的长度
    public int size(){
        //和单链表的是一样的
        int count = 0;
        LinkNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //打印双向链表
    public void display(){
        //和单链表的打印是一样的
        LinkNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
      //暴力清空this.head =null this.last=null;
        while(head != null){
            LinkNode curNext = this.head.next;
            head.next = null;
            head.prev = null;
            head = curNext;
            curNext = curNext.next;
        }
        //last一定要手动制空
        this.last = null;
    }
}
