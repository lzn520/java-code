package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 21:32
 */
public class ExitOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("退出系统！");
        System.exit(0);
    }
}
