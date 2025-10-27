package Library.Loan;
import Library.Book.*;
import Library.Exception.LoanPolicyViolationException;
import Library.Exception.LoanedBookException;
import Library.Exception.NoMemberException;
import Library.Exception.NotLoanedBookException;
import Library.Member.*;
import java.util.*;

interface LibraryLoanManagement{
    void LoanBook(Member m, LibraryBook b);
    void ReturnBook(Member m, LibraryBook b);

}


public class LoanManagement implements LibraryLoanManagement{
    private HashMap<Member, ArrayList<LibraryBook>> loans;
    private HashMap<LibraryBook, Integer> loan_status = new HashMap<>();
    private LoanPolicy lp;

    public void LoanBook(Member m, LibraryBook b){
        try{
            if(!loans.containsKey(m)){
                //throw new NoMemberException();
                loans.put(m, new ArrayList<LibraryBook>());
            }

            ArrayList<LibraryBook> cur = loans.get(m);
            if(cur.size()>=lp.getPolicy()){   //대여 횟수를 초과했을 때
                throw new LoanPolicyViolationException();
            }

            if(cur.contains(b)){   //이미 대여한 책이면
                throw new LoanedBookException();
            }

            cur.add(b);
        } catch(LoanPolicyViolationException | LoanedBookException e){
            System.out.println(e);
        }
    }

    public void ReturnBook(Member m, LibraryBook b){
        try{
            if(!loans.containsKey(m)){
                throw new NoMemberException();
            }

            ArrayList<LibraryBook> cur = loans.get(m);
            if(!cur.contains(b)){
                throw new NotLoanedBookException();
            }

            cur.remove(b);
        } catch(NoMemberException | NotLoanedBookException e){
            System.out.println(e);
        }

    }
}
