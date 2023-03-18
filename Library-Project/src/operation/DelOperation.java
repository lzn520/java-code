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
public class DelOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("删除图书！");
        System.out.println("请输入要删除的图书名字：");
        String name = scanner.nextLine();
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i < bookList.getUsedSize()){//这里说明查找到了该书
            for (int j = i; j < bookList.getUsedSize()-1; j++) {
                Book book = bookList.getPos(j+1);//先拿到j+1的书
                bookList.setBook(j,book);//将j+1的书放入j
            }
            System.out.println("删除成功！");
            bookList.books[bookList.getUsedSize()-1] = null;//将最后一个制空
            bookList.setUsedSize(bookList.getUsedSize()-1);

        }else{
            System.out.println("查无此书！删除失败!");
        }
    }
}
