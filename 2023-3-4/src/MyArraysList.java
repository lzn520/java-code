import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-05
 * Time: 18:56
 */
public class MyArraysList {
    private  int[] elem;
    private  int usedSize;
    //构造函数
    public MyArraysList(){
        this.elem = new int[10];
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
     // 在 pos 位置新增元素
      public void add(int pos, int data) {
        //1.判断位置是否合法
        if(pos < 0 || pos > usedSize) {
            System.out.println("位置不合法");
            return;
        }
        //2.判断是否满，满就扩容
          if(isFull()) {
             this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
          }
        //3.如果放入的位置有元素，移动数据
          for (int i = usedSize-1; i >= pos ; i--) {
              this.elem[i+1] = this.elem[i];
          }
          this.elem[pos] = data;
          usedSize++;
      }
      //判断顺序表是否满了
      public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
        //上面的可以改成一句
         /* return this.useSized == this.elem.length;*/
      }
      //判断顺序表是否为空
       public boolean isEmpty(){
        return this.usedSize == 0;
       }
      // 判定是否包含某个元素
       public boolean contains(int toFind) {

        if(isEmpty()){
            System.out.println("顺序表为空");
            return false;
        }
           for (int i = 0; i < this.usedSize; i++) {
               if(this.elem[i] == toFind){
                   return true;
               }
           }
           return  false;
       }
      // 查找某个元素对应的位置,找不到返回-1
       public int search(int toFind) {
        //判断顺序表是否为空
        if(isEmpty()){
            System.out.println("顺序表为空");
            return -1;
        }
        //查找该元素对应的位置
           for (int i = 0; i < this.usedSize; i++) {
               if(this.elem[i] == toFind){
                   return i;
               }
           }
           return -1;
       }
      // 获取 pos 位置的元素
         public int getPos(int pos) {
         //判断pos是否合法
           if(pos < 0 || pos >= usedSize)
           {
               System.out.println("pos 位置不合法");
               return -1; //业务上的处理是这样，但是后期可以抛出异常，不考虑是否有-1元素
           }
           //判断顺序表是否为空
             if(isEmpty()){
                 System.out.println("顺序表为空");
                 return -1;
             }
             //获取pos位置的元素
             return this.elem[pos];
         }
      // 给 pos 位置的元素设（更新的意思）为 value
         public void setPos(int pos, int value) {
             //判断pos是否合法
             if(pos < 0 || pos >= usedSize)
             {
                 System.out.println("pos 位置不合法");
                 return ; //业务上的处理是这样，但是后期可以抛出异常，不考虑是否有-1元素
             }

             this.elem[pos] = value;
         }
        //删除第一次出现的关键字key
          public void remove(int toRemove) {
        //1.看顺序表是否为空
             if(isEmpty()){
                 System.out.println("顺序表为空");
                 return;
             }
             //获取关键字的位置并删除
              int i = search(toRemove);
              if(search(toRemove) == -1){
                  System.out.println("顺序表中没有该元素");
                  return;
              }
              for ( i = search(toRemove); i < this.usedSize-1; i++) {
                  this.elem[i] = this.elem[i+1];
              }
              usedSize--;
          }
      // 获取顺序表长度
         public int size() {
           return this.usedSize;
         }
      // 清空顺序表
          public void clear() {
               this.usedSize = 0;
               //如果数组中是引用数据类型就要制空,如下
              /*for (int i = 0; i < this.usedSize; i++) {
                  this.elem[usedSize] = null;
              }*/
          }
}
