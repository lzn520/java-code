import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:数组的定义与使用
 * User: LZN
 * Date: 2023-02-24
 * Time: 13:34
 */
public class Text {
    public static void main(String[] args) {
        int[] array1={1,2,3,4,5};

        int[] array2=new int[]{1,2,3,4};
        System.out.println(Arrays.toString(array2));
        for (int x:array1) {
            System.out.println(x);
        }
    }

}
