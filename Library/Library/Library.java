package Library.Library;
import Library.Book.*;
import Library.Exception.*;
import Library.Loan.*;
import Library.Member.*;
import Library.User.*;

public class Library {

    private BookManagementInterface BMI;
    private LibraryLoanManagement LLM;
    private LibraryMemberManagement LMM;


    public Library(BookManagementInterface BMI, LibraryLoanManagement LLM, LibraryMemberManagement LMM){
        this.BMI = BMI;
        this.LLM = LLM;
        this.LMM = LMM;
    }

    public void changeBookManagementInterface(BookManagementInterface BMI){
        this.BMI = BMI;
    }

    public void changeLibraryLoanManagement(LibraryLoanManagement LLM){
        this.LLM = LLM;
    }

    public void changeLibraryMemberManagement(LibraryMemberManagement LMM){
        this.LMM = LMM;
    }

    public void addBook(Book book, int count, BookCategory category){
        LibraryBook LBook = new LibraryBook(book, category);
        BMI.AddBook(LBook, count);
    }

    public void removeBook(LibraryBook book, int count){
        BMI.DeleteBook(book, count, LLM.getLoanStatus(book));
    }

    public void addUser(User u, String username){
        //Member Mu = new Member(u, username);
        LMM.addMember(u, username);
    }

    public void editUser(Member m, User u){
        LMM.editMember(m, u);
    }

    public void delUser(Member m){
        LMM.deleteMember(m, LLM.getUserLoanCount(m));
    }

    public void LoanBook(Member m, LibraryBook lb){    
        LLM.LoanBook(m, lb, BMI.getBookCount(lb));
    }

    public void ReturnBook(Member m, LibraryBook lb){
        LLM.ReturnBook(m, lb);
    }

    public void ChangePolicy(int MAX_LOAN_BOOK){
        LLM.changeMaxLoanPolicy(MAX_LOAN_BOOK);
    }

    public Member findUser(User o){
        return LMM.getMember(o);
    }

    public LibraryBook searchBook(String title, String author, String publisher){
        return BMI.getBook(title, author, publisher);
    }

}
