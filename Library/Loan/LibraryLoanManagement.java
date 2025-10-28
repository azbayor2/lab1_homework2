package Library.Loan;
import Library.Member.*;
import Library.Book.*;

public interface LibraryLoanManagement{
    void LoanBook(Member m, LibraryBook b, int totalBookCount);
    void ReturnBook(Member m, LibraryBook b);
    void changeMaxLoanPolicy(int MAX_LOAN_BOOK);
    int getLoanStatus(LibraryBook lb);
    int getUserLoanCount(Member m);

}