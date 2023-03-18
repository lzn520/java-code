package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 21:46
 */
public interface IOperation {
    void work(BookList bookList);
    Scanner scanner = new Scanner(System.in);
}
