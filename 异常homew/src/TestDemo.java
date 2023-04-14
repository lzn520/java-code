import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-08
 * Time: 10:17
 */
public class TestDemo {

    public static String uname = "admin";
    public static String upassword = "123456";

    public static void login(String name,String password) throws uNameException, uPasswordException {
        if(!name.equals(uname)){
            throw new uNameException("大哥 用户名错了");
        }
        if(!password.equals(upassword)){
            throw  new uPasswordException("大哥 密码错了");
        }
        //走到这里说明程序没有异常
        System.out.println("登陆成功！");
    }
    //实现一个简单的控制台版用户登陆程序, 程序启动提示用户输入用户名密码. 如果用户名密码出错, 使用自定义异常的方式来处理
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
              try{
                  login(name,password);
              }catch (uNameException e){
                  e.printStackTrace();
              }catch (uPasswordException e){
                  e.printStackTrace();
              }
    }

}
