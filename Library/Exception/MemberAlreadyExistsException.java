package Library.Exception;

public class MemberAlreadyExistsException extends Exception{
    @Override
    public String toString(){
        return "Member already Exists";
    }
}