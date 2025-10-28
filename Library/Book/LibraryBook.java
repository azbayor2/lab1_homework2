package Library.Book;
import java.util.*;

import Library.Library.Library;

public class LibraryBook{
    //Integer BookNumber;
    private BookCategory Category;
    private Book book;

    public LibraryBook(Book book, BookCategory Category) {
        this.book = book;
        //this.BookNumber = BookNumber;
        this.Category = Category;
    }

    public LibraryBook(LibraryBook lb){
        this.Category = lb.Category;
        this.book = new Book(lb.book);
    }

    public Book getBook(){
        return new Book(book);
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

    public boolean equals(LibraryBook lb){
        if(this.book.equals(lb.book)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book.Title, book.Author, book.Publisher);
    }
}