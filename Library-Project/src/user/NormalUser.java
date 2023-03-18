package user;

import book.BookList;
import operation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 15:51
 */
public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
    }

    public void menu(){
        System.out.println("============普通用户菜单============");
        System.out.println(" hello "+this.name+" 欢迎来到图书管理系统！");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
    }

    public  void operation(int choice,BookList bookList){
        IOperation[] iOperations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
        iOperations[choice].work(bookList);
    }

}
