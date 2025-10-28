package Library.Exception;

public class UserCurrentlyHaveLoanException extends Exception {
    @Override
    public String toString(){
        return "Specified user has a loaned book";
    }
}
