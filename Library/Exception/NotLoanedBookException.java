package Library.Exception;

public class NotLoanedBookException extends Exception{
    @Override
    public String toString(){
        return "Book is not loaned by current user";
    }
}