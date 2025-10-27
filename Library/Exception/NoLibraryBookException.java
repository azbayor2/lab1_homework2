package Library.Exception;

public class NoLibraryBookException extends Exception{
    @Override
    public String toString(){
        return "There is no specified book in this Library";
    }
}
