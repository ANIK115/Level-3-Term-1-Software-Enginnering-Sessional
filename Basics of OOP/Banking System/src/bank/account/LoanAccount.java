package bank.account;

import java.util.Date;

public class LoanAccount extends Account{

    public static final float yearlyServiceCharge = 0;
    public static final float loanInterestRate = (float) 0.10;
    public static final float allowableLoanPercentage = (float) 0.05;

    public LoanAccount(String name, String accountType, Date regDate, float loan) {
        super(name, accountType, regDate);
        balance = loan;
    }

    public static Account createAccount(String name, String accountType, float amount)
    {
        return new LoanAccount(name, Account.STUDENT, new Date(), amount);
    }

    @Override
    public boolean deposit(float amount) {
        if (amount > 0)
        {
            if(amount <= loan) {
                loan -= amount;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean requestLoan(float amount) {
        if(amount <= allowableLoanPercentage*balance)
        {
            reqLoan = amount;
            loanStatus = "Pending";
            System.out.println("Loan request successful. Sent for approval");
            return true;
        }
        return false;
    }

    @Override
    public void queryDeposit() {
        System.out.println("Current loan balance "+balance);
    }

    @Override
    public void serviceCharge() {
        balance += yearlyServiceCharge;
    }

    @Override
    public void yearlyInterest() {
        balance += balance*loanInterestRate;
    }
}
