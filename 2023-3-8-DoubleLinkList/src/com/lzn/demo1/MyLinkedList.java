package com.lzn.demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-09
 * Time: 23:10
 */
class LinkNode{
    public int val;//假设节点内放的是int型的数据
    public LinkNode next;//用来存下一个结点的地址
    public LinkNode prev;//用来存上一个结点的地址

    //用构造方法对结点的数据赋初值，这个方法并不是必须的，上面三个才是结点最主要的
    public LinkNode(int val){
        this.val = val;//this表示当前对象的引用
    }
}
public class MyLinkedList {
    LinkNode head;//链表的头引用，用来存链表首结点的地址
    LinkNode last;//用来存链表的尾结点的地址
    //打印链表display()
    public void display(){
        //和单链表的打印是一样的
        LinkNode cur = this.head;//链表原来的head我们不能动不然会导致链表丢失，所以用一个临时变量来接收头，用临时变量来遍历链表
        while(cur != null){
            System.out.print(cur.val+" ");//打印cur的val值，也就是打印节点中的数据域
            cur = cur.next;//让cur走向下一个结点
        }
        System.out.println();//换行
    }
    //得到链表的长度
    public int size(){
        //和单链表计算长度是一样的
        int count = 0;//用count来计数链表的长度
        LinkNode cur = this.head;//链表原来的head我们不能动不然会导致链表丢失，所以用一个临时变量来接收头，用临时变量来遍历链表
        while(cur != null){
            count++;
            cur = cur.next;//让cur走向下一个结点
        }
        return count;//返回count的值
    }
    //头插法
    public void addFirst(int data){
         LinkNode node = new LinkNode(data);//new一个节点，用构造方法对其数据域赋值
        //对空链表进行头插，这个时候链表中什么节点都没有，head和last都为null，只需要将他们都指向该节点就好
        if(this.head == null){//链表头引用为空说明链表是一个空链表
            this.head = node;
            this.last = node;
        }else{//链表非空
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        LinkNode node = new LinkNode(data);//new一个节点，用构造方法对其数据域赋值
        //对空链表进行尾插，这个时候链表中什么节点都没有，head和last都为null，只需要将他们都指向该节点就好
        if(this.last == null){//链表尾引用为空说明链表是一个空链表
            this.head = node;
            this.last = node;
        }else{//链表非空
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    //找到该下标的前一个节点
    public LinkNode searchPrev(int index){
        LinkNode cur = this.head;
        while(index-1 != 0 ){//我们会发现头走到index的前一个节点只需要走index-1步
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if (index < 0 || index > size()){//输入的下标不合法
            return false;
        }
        if(index == 0 ){
            addFirst(data);//index为0进行头插
            return true;
        }else if(index == size()){
            addLast(data);//index和链表size一样进行尾插
            return true;
        }
        //走到这里说明是在其他下标插入
        LinkNode node = new LinkNode(data);//new一个节点，用构造方法对其数据域赋值
        LinkNode cur = searchPrev(index);//用来接收前一个节点地址
        node.prev = cur;
        node.next = cur.next;
        cur.next.prev =node;
        return true;

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        LinkNode cur = this.head;//用cur来遍历链表
        while(cur != null){//cur不为null的时候，进行循环
            if(cur.val == key){//当cur的数据域的值和key相等，返回true
                return true;
            }
            cur = cur.next;//没找到关键字，cur继续向后走
        }
        return false;//走到这说明没有该关键字key
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //分三种 1.删除的是头，2.删除的是尾，3。删除的是其他
        LinkNode cur = this.head;
        while (cur != null){
            if(cur.val == key){
                //1.删除的是头
                if(cur == this.head){
                    if(this.head.next == null){//为防止链表只有一个元素出现空指针异常
                        this.head = null;
                        this.last = null;
                    }else {
                        this.head = this.head.next;
                        this.head.prev = null;
                    }
                    return ;
                }else if(cur == this.last){//2。删除的是尾
                    this.last = this.last.prev;
                    this.last.next = null;
                    return;
                }
                //走到这说明删除的是其他
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;//如果前面没有匹配的，cur继续向后面找
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        //分三种 1.删除的是头，2.删除的是尾，3。删除的是其他
        LinkNode cur = this.head;
        while (cur != null){
            if(cur.val == key){
                //1.删除的是头
                if(cur == this.head){
                    if(this.head.next == null){//为防止链表只有一个元素出现空指针异常
                        this.head = null;
                        this.last = null;
                    }else {
                        this.head = this.head.next;
                        this.head.prev = null;
                    }
                }else if(cur == this.last){//2。删除的是尾
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    //走到这说明删除的是其他
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;//如果前面没有匹配的，cur继续向后面找
        }
    }

    //清空链表
    public void clear(){
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
