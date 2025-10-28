package Library.Loan;

public class LoanPolicy implements LibraryLoanPolicy{
    private int MAX_LOAN_COUNT = 0;

    public LoanPolicy(int MAX_LOAN_COUNT){
        this.MAX_LOAN_COUNT = MAX_LOAN_COUNT;
    }

    @Override
    public void setPolicy(int MAX_LOAN_COUNT){
        this.MAX_LOAN_COUNT = MAX_LOAN_COUNT;
    }
    
    @Override
    public int getPolicy(){
        return MAX_LOAN_COUNT;
    }

}
