package user;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 15:50
 */
public class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }
    public void menu(){}
    public  void operation(int choice, BookList bookList){}
}
