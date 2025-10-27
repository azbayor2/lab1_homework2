package Library.Book;
import java.util.*;


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
