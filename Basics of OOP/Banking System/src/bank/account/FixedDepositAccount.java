package bank.account;

import java.util.Date;

public class FixedDepositAccount extends Account{

    private static final float minimumInitialDeposit = 100000;
    private static final float minimumDeposit = 50000;
    private static final float maturityPeriod = 1;
    private static final float maximumAllowableLoan = 100000;
    private static float interestRate = (float) 0.15;
    private static final float yearlyServiceCharge = 500;

    public FixedDepositAccount(String name, String accountType, Date regDate, float amount) {
        super(name, accountType, regDate);
        balance += amount;
        reqLoan = 0;
        loanStatus = "N/A";
    }

    public static Account createAccount(String name, String accountType, float amount)
    {
        if(amount < minimumInitialDeposit)
        {
            return null;
        }
        return new FixedDepositAccount(name, Account.STUDENT, new Date(), amount);
    }

    public static float getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(float interestRate) {
        FixedDepositAccount.interestRate = interestRate;
    }


    @Override
    public boolean deposit(float amount) {
        if(amount >= minimumDeposit)
        {
            balance += amount;
            System.out.println(amount+" deposited; current balance "+getBalance()+"$");
            return true;
        }
        System.out.println("You should deposit at least "+minimumDeposit);
        return false;
    }

    @Override
    public boolean withDraw(float amount) {
        if(period >= maturityPeriod)
        {
            if(amount <= balance)
            {
                balance -= amount;
                System.out.println("Successfully withdrawn amount "+amount+", current balance is "+balance);
                return true;
            }
            System.out.println("Invalid transaction; current balance "+getBalance());
            return false;
        }
        System.out.println("Your account must reach a maturity period of "+maturityPeriod+" year");
        return false;
    }

    public boolean requestLoan(float amount) {
        if(loan+ amount <= maximumAllowableLoan)
        {
            reqLoan = amount;
            loanStatus = "pending";
            System.out.println("Loan request successful. Sent for approval");
            return true;
        }
        System.out.println("Maximum allowable loan "+maximumAllowableLoan);
        return false;
    }

    public void queryDeposit() {
        System.out.println("Current balance "+balance+", loan "+loan);
    }

    public void serviceCharge() {
        balance -= yearlyServiceCharge;
    }

    public void yearlyInterest() {
        balance += balance*interestRate;
        balance -= loan*0.10;
    }
}
