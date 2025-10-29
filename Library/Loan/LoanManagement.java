package Library.Loan;
import Library.Book.*;
import Library.Exception.*;
import Library.Member.*;
import java.util.*;


public class LoanManagement implements LibraryLoanManagement{
    private HashMap<Member, ArrayList<LibraryBook>> loans = new HashMap<>();
    private HashMap<LibraryBook, Integer> loan_status = new HashMap<>();
    private LibraryLoanPolicy lp;

    public LoanManagement(LibraryLoanPolicy lp){
        this.lp = lp;
    }

    public void LoanBook(Member m, LibraryBook b, int totalBookCount){
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

            int loaned_book = 0;

            if(loan_status.containsKey(b))
                loaned_book=loan_status.get(b);

            if(totalBookCount-loaned_book<=0){ //대여할 수 있는지 확인
                throw new LoanCountExcessException();
            }

            cur.add(b); //현재 사용자에 빌린 책 추가하기

            int prev = 0;
            if(loan_status.containsKey(b)) prev = loan_status.get(b);  //책의 대여 현황 저장하기
            loan_status.put(b, prev+1);

        } catch(LoanPolicyViolationException | LoanedBookException | LoanCountExcessException e){
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

            int prev = 0;
            if(loan_status.containsKey(b)) prev = loan_status.get(b);
            loan_status.put(b, prev-1);

            
        } catch(NoMemberException | NotLoanedBookException e){
            System.out.println(e);
        }

    }

    public void changeMaxLoanPolicy(int MAX_LOAN_BOOK){
        lp.setPolicy(MAX_LOAN_BOOK);
    }

    public int getLoanStatus(LibraryBook lb){
        if(!loan_status.containsKey(lb)){
            return 0;
        }

        return loan_status.get(lb);
    }

    public int getUserLoanCount(Member m){
        if(!loans.containsKey(m)) return 0;
        return loans.get(m).size();
    }
}
