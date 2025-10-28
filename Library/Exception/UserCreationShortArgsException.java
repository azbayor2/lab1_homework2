package Library.Exception;

public class UserCreationShortArgsException extends Exception{
    @Override
    public String toString(){
        return "Must-have field is Empty";
    }
}
