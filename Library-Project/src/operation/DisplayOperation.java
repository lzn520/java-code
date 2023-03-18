package operation;

import book.Book;
import book.BookList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 16:01
 */
public class DisplayOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("显示图书！");
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);
            System.out.println(book);
        }
    }
}
