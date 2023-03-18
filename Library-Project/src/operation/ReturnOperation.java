package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 21:32
 */
public class ReturnOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("归还图书！");
        System.out.println("请输入图书名字：");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book =  bookList.getPos(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }
        System.out.println("没有该书！归还失败");
    }

}

