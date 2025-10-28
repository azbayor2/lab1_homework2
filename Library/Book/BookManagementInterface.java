package Library.Book;

public interface BookManagementInterface{
    public void AddBook(LibraryBook book, int count);
    public void DeleteBook(LibraryBook book, int Count, int loanedBookCount);
    public LibraryBook getBook(String title, String author, String publisher);
    public int getBookCount(LibraryBook lb);
}