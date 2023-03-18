package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-03-18
 * Time: 15:45
 */
public class BookList {
   public Book[] books = new Book[10];
   private int usedSize = 0;

   public BookList() {
      books[0] = new Book("三国演义","罗贯中",18,"名著",false);
      books[1] = new Book("西游记","吴承恩",18,"名著",false);
      books[2] = new Book("Java","雷昭妮",18,"学习",false);
      usedSize = 3;
   }

   public int getUsedSize() {
      return usedSize;
   }

   public void setUsedSize(int usedSize) {
      this.usedSize = usedSize;
   }

   /**
    * 获得某个下标的书籍
    * @param pos
    * @return
    */
   public Book getPos(int pos){
      return this.books[pos];
   }

   /**
    * 将某书放入下标
    * @param pos
    * @param book
    */
   public void setBook(int pos,Book book){
      this.books[pos] = book;
   }


}
