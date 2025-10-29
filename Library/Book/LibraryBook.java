package Library.Book;
import java.util.*;


public class LibraryBook{
    //Integer BookNumber;
    private BookCategory Category;
    private Book book;

    public LibraryBook(Book book, BookCategory Category) {
        this.book = new Book(book);
        //this.BookNumber = BookNumber;
        this.Category = Category;
    }

    public LibraryBook(LibraryBook lb){
        this.Category = lb.Category;
        this.book = new Book(lb.book);  //방어적 복사
    }

    public Book getBook(){
        return new Book(book);  //방어적 복사
    }

    @Override
    public boolean equals(Object oBook){
        Book b = null;
        if(oBook instanceof LibraryBook){
            LibraryBook lb = (LibraryBook)oBook;
            b = lb.book;
        } else if(oBook instanceof Book)
            b = (Book)oBook;

        return this.book.equals(b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book.Title, book.Author, book.Publisher);
    }
}