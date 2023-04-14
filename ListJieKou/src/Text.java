import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-14
 * Time: 10:05
 */
public class Text {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();//接口不能实例化,必须去实例化List的实现类。
        list.add(10);
        list.add(20);
        System.out.println(list);
    }
}
