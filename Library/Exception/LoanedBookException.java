package Library.Exception;

public class LoanedBookException extends Exception{
    @Override
    public String toString(){
        return "Book already loaned";
    }
}