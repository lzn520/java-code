/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-05
 * Time: 18:56
 */
public class TextData {

    public static void main(String[] args) {
        MyArraysList myArraysList = new MyArraysList();
        myArraysList.add(0,1);
        myArraysList.add(1,2);
        myArraysList.add(2,3);
        myArraysList.add(3,4);
        myArraysList.display();
        myArraysList.add(3,5);
        myArraysList.display();
        System.out.println(myArraysList.contains(5));
        System.out.println(myArraysList.search(10));
        System.out.println(myArraysList.getPos(4));
        System.out.println("顺序表长度为" + myArraysList.size());
        myArraysList.remove(7);
        myArraysList.display();
        System.out.println("=========");
        myArraysList.clear();
        myArraysList.display();



    }

}
