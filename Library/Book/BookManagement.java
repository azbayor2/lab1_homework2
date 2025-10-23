package Library.Book;
import java.util.*;


enum BookCategory{
    Fiction, Drama, Mystery, Thriller, Horror, Romance, Fantasy, Sci_Fi, Biography,
    Self_Help, Poetry, Adventure, Erotica, Spiritual, Travel
}


class LibraryBook extends Book{
    Integer BookNumber;
    BookCategory Category;

    public LibraryBook(Book book, Integer BookNumber, BookCategory Category) {
        super(book);
        this.BookNumber = BookNumber;
        this.Category = Category;
    }

    @Override
    public boolean equals(Object oBook){
        Book book = (Book)oBook;
        if(this.Author.equals(book.Author) && this.Publisher.equals(book.Publisher)&&
        this.Title.equals(book.Title)) return true;

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Title, Author, Publisher);
    }
}

interface BookManagementInterface{
    public void AddBook(Book book, BookCategory cat, int count) throws Exception;
    public void DeleteBook(Integer BookNumber, Integer Count) throws Exception;
}

public class BookManagement implements BookManagementInterface{  //예외처리 하기 (책 개수 <=0 일 때)
    private int BookCount = 0;
    private HashMap<Integer, Integer> BookStocks = new HashMap<>();
    private HashMap<LibraryBook, Integer> BookNum = new HashMap<>();

    public void AddBook(Book book, BookCategory cat, int count){
        int booknum;
        if(BookNum.containsKey(book))
            booknum = BookNum.get(book);
        else{
            BookNum.put(new LibraryBook(book, BookCount, cat), BookCount);
            booknum = BookCount;
            BookCount++;
        }

        int prevcount = 0;
        if(BookStocks.containsKey(booknum))
            prevcount = BookStocks.get(booknum);

        BookStocks.put(booknum, prevcount+count);
    }

    public void DeleteBook(Integer BookNumber, Integer Count) throws Exception{  //예외처리 하기 (책 개수 0이하 일때, 버리는 책이 더 많을 때)
        if(!BookStocks.containsKey(BookNumber))
            throw new Exception();

        int CurBookCount = BookStocks.get(BookNumber);

        if(CurBookCount<Count)
            throw new Exception();

        BookStocks.put(BookNumber, CurBookCount-Count);
    }

}
