package Library.Exception;

public class LoanCountExcessException extends Exception {
    @Override
    public String toString(){
        return "Book currently fully loaned";
    }
}
