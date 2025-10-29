package Library.Exception;

public class FewerBookException extends Exception {
    @Override
    public String toString(){
        return "Fewer books are in the Library";
    }
}