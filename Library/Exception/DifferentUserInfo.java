package Library.Exception;

public class DifferentUserInfo extends Exception {
    @Override
    public String toString(){
        return "Cannot change Birthdate";
    }
}
