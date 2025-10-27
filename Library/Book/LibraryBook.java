package Library.Book;
import java.util.*;

enum BookCategory{
    Fiction, Drama, Mystery, Thriller, Horror, Romance, Fantasy, Sci_Fi, Biography,
    Self_Help, Poetry, Adventure, Erotica, Spiritual, Travel
}


public class LibraryBook{
    Integer BookNumber;
    BookCategory Category;
    Book book;

    public LibraryBook(Book book, Integer BookNumber, BookCategory Category) {
        this.book = book;
        this.BookNumber = BookNumber;
        this.Category = Category;
    }

    @Override
    public boolean equals(Object oBook){
        Book book = (Book)oBook;
        if(book.Author.equals(book.Author) && book.Publisher.equals(book.Publisher)&&
        book.Title.equals(book.Title)) return true;

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book.Title, book.Author, book.Publisher);
    }
}