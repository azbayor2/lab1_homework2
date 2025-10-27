package Library.Exception;

public class NoMemberException extends Exception{
    @Override
    public String toString(){
        return "No member found";
    }
}