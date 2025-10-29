package Library.Exception;

public class DifferentUserInfoException extends Exception {
    @Override
    public String toString(){
        return "Cannot change Birthdate";
    }
}
