/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-21
 * Time: 8:38
 */
public class TextDemo {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);
    }

    public static void main2(String[] args) {
        String str = "hello lzn";
        String str2 = str;
        System.out.println(str);
        System.out.println(str2);
        System.out.println("=============");
        str2 = "你好 lzn";
        System.out.println(str);
        System.out.println(str2);

    }
    public static void main1(String[] args) {
        //方式一：
        String str = "hello lzn";
        System.out.println(str);
        //方式二：由于String是引用类型所以可以通过new来创建
        String str2 = new String("hello lzn");
        System.out.println(str2);
        //方式三：
        char[] array = {'h','e','l','l','o'};
        String str3 = new String(array);
        System.out.println(str3);
    }
}
