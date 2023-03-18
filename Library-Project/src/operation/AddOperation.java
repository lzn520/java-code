package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 16:00
 */
public class AddOperation implements IOperation {
       public void work(BookList bookList){
           System.out.println("新增图书！");
          /* Scanner scanner = new Scanner(System.in);
           System.out.println("请输入图书的名字");
           bookList.books[bookList.getUsedSize()].setName(scanner.nextLine());
           System.out.println("请输入图书的作者");
           bookList.books[bookList.getUsedSize()].setAuthor(scanner.nextLine());
           System.out.println("请输入图书的类型");
           bookList.books[bookList.getUsedSize()].setType(scanner.nextLine());*/
           System.out.println("请输入图书的名字");
           String name = scanner.nextLine();
           System.out.println("请输入图书的作者");
           String author = scanner.nextLine();
           System.out.println("请输入图书的类型");
           String type = scanner.nextLine();
           System.out.println("请输入图书的价格");
           int price = scanner.nextInt();//要将nextLine的写在nextint前面否则会出现奇怪的现象
           Book book = new Book(name,author,price,type,false);
           int size = bookList.getUsedSize();
           bookList.setBook(size,book);
           bookList.setUsedSize(size+1);
           System.out.println("添加成功！");
       }
}
