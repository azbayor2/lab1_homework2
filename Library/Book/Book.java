package Library.Book;

import java.util.Objects;

class Book {
    protected String Title;
    protected String Author;
    protected String Publisher;

    public Book(String Title, String Author, String Publisher){
        this.Title = Title;
        this.Author = Author;
        this.Publisher = Publisher;
    }

    public Book(Book book){
        this.Title = book.Title;
        this.Author = book.Author;
        this.Publisher = book.Publisher;
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
