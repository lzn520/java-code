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
    //清空单链表
    public void clear(){
        //暴力清空，只要结点没有被引用就会自动回收
        this.head = null;
    }
}
