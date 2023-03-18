package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 21:32
 */
public class BorrowOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("借阅图书！");
        System.out.println("请输入图书名字：");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book =  bookList.getPos(i);
            if(book.getName().equals(name)){
                book.setBorrowed(true);
                System.out.println("借阅成功！");
                return;
            }
        }
        System.out.println("没有该书！借阅失败");
    }
}
