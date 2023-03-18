package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 21:31
 */
public class FindOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("查找图书！");
        System.out.println("请输入要查找图书的名字:");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            if (book.getName().equals(name)){
                System.out.println(book);
                System.out.println("查找成功！");
                return;
            }
        }
        System.out.println("无此书！查找失败！");
    }

}
