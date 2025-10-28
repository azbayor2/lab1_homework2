package Library.Book;
import Library.Exception.FewerBookException;
import Library.Exception.NoLibraryBookException;
import java.util.*;


public class BookManagement implements BookManagementInterface{  //예외처리 하기 (책 개수 <=0 일 때)
    //private int BookCount = 0;
    private HashMap<LibraryBook, Integer> BookStocks = new HashMap<>();
    //private HashMap<LibraryBook, Integer> BookNum = new HashMap<>();

    public void AddBook(LibraryBook book, int count){
        if(!BookStocks.containsKey(book)){
            BookStocks.put(book, count);
            return;
        }

        int prevCount = BookStocks.get(book);
        BookStocks.put(book, prevCount+count);
    }

    public void DeleteBook(LibraryBook book, int Count, int loanedBookCount){  //예외처리 하기 (책 개수 0이하 일때, 버리는 책이 더 많을 때)
        try{
            if(!BookStocks.containsKey(book))
                throw new NoLibraryBookException();

            int CurBookCount = BookStocks.get(book);

            if(CurBookCount<Count)
                throw new FewerBookException();

            BookStocks.put(book, CurBookCount-Count);
        } catch(NoLibraryBookException | FewerBookException e){
            System.out.println(e);
        }
    }

    public LibraryBook getBook(String title, String author, String publisher){
        Book find = new Book(title, author, publisher);
        try{
            LibraryBook lb = null;
            for(LibraryBook cur: BookStocks.keySet()){
                if(!cur.equals(find)) continue;
                lb = new LibraryBook(cur);
                break;
            }
            if(lb==null) throw new NoLibraryBookException();

            return lb;
        } catch(NoLibraryBookException e){
            System.out.println(e);
            return null;
        }
    }

    public int getBookCount(LibraryBook lb){
        try{
            if(!BookStocks.containsKey(lb)){
                throw new NoLibraryBookException();
            }

            return BookStocks.get(lb);
            
        } catch(NoLibraryBookException e){
            System.out.println(e);
            return 0;
        }
    }

}
