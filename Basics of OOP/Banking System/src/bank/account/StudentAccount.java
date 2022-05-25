package bank.account;

import java.util.Date;

public class StudentAccount extends Account{

    public static final float maximumAllowableLoan = 1000;
    public static final float maxWithDraw = 10000;
    private static float interestRate = (float) 0.05;
    public static final float yearlyServiceCharge = 500;

    public StudentAccount(String name, String accountType, Date regDate, float initialDeposit) {
        super(name, accountType, regDate);
        if(initialDeposit >= 0)
            this.balance = initialDeposit;
        else
        {
            System.out.println("Can't deposit negative amount");
            System.out.println("Initializing deposit with 0");
            this.balance = 0;
        }
        this.loan = 0;
        this.reqLoan = 0;
        loanStatus = "N/A";
    }

    public static Account createAccount(String name, String accountType, float amount)
    {
        return new StudentAccount(name, Account.STUDENT, new Date(), amount);
    }


    public boolean deposit(float amount) {
        if(amount > 0)
        {
            balance += amount;
            System.out.println(amount+" deposited; current balance "+getBalance()+"$");
            return true;
        }
        return false;
    }

    @Override
    public boolean withDraw(float amount) {
        if(amount <= maxWithDraw)
        {
            balance -= amount;
            System.out.println("Successfully withdrawn amount "+amount+", current balance is "+balance);
            return true;
        }
        System.out.println("Invalid transaction; current balance "+getBalance());
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
        System.out.println("Maximum loan that can be requested is "+maximumAllowableLoan);
        return false;
    }

    public void queryDeposit() {
        System.out.println("Current Balance "+balance+", loan "+loan);
    }

    public void serviceCharge() {
        balance -= yearlyServiceCharge;
    }

    public void yearlyInterest() {

        balance += balance*interestRate;
        balance -= loan*0.10;
    }

    public static void setInterestRate() {
        interestRate = (float) 0.05;
    }

    public static void changeInterestRate(float amount)
    {
        interestRate = amount;
    }

}
