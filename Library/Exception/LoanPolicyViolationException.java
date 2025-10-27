package Library.Exception;

public class LoanPolicyViolationException extends Exception{
    @Override
    public String toString(){
        return "Loan policy violated: loaned books already maxed";
    }
}