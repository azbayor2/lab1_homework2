package Library.Loan;
import Library.Member.*;
import Library.Book.*;
import java.util.*;

interface LibraryLoanManagement{
    void LoanBook(Member m, LibraryBook b);
    void ReturnBook(Member m, LibraryBook b);

}

public class LoanManagement implements LibraryLoanManagement{
    private HashMap<Member, ArrayList<LibraryBook>> loans;
    private LoanPolicy lp;

    public void LoanBook(Member m, LibraryBook b){
        if(!loans.containsKey(m)){
            throw new Exception();
        }

        ArrayList<LibraryBook> cur = loans.get(m);

    }

    public void ReturnBook(Member m, LibraryBook b){


    }


}
