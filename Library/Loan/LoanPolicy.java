package Library.Loan;

interface LibraryLoanPolicy{
    void setPolicy(int MAX_LOAN_COUNT);
    int getPolicy();
}

public class LoanPolicy implements LibraryLoanPolicy{
    private int MAX_LOAN_COUNT = 0;

    @Override
    public void setPolicy(int MAX_LOAN_COUNT){
        this.MAX_LOAN_COUNT = MAX_LOAN_COUNT;
    }
    
    @Override
    public int getPolicy(){
        return MAX_LOAN_COUNT;
    }
}
