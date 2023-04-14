package user;

import book.BookList;
import user.exception.uNameException;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 21:36
 */
public class Main {

    public static  User  login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();
       /* if(!name.equals("雷昭妮")){
            throw new uNameException("姓名错误异常");
        }*/
        System.out.println("请输入你的身份：1：管理员，0：普通用户");

        int id = scanner.nextInt();
        if(id == 1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
       User user = login(); //发生向上转型
       /* try{
            User user = login();
        }catch (uNameException e){
            e.printStackTrace();
        }*/
        while(true){
            user.menu();//发生动态绑定
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            user.operation(choice,bookList);
        }
    }
}