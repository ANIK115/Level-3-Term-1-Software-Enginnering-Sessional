package bank.account;

import java.util.Date;

public class SavingsAccount extends Account{

    public static final float minimumAmount = 1000;
    public static final float maximumAllowableLoan = 10000;
    private static float interestRate = (float) 0.1;
    public static final float yearlyServiceCharge = 500;

    public SavingsAccount(String name, String accountType, Date regDate, float initialDeposit) {
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
        return new SavingsAccount(name, Account.STUDENT, new Date(), amount);
    }

    public static void setInterestRate(float interestRate) {
        SavingsAccount.interestRate = interestRate;
    }

    @Override
    public boolean withDraw(float amount) {
        if(balance-amount < minimumAmount)
        {
            System.out.println("Can't withdraw as it results in a deposit of less than "+minimumAmount);
            System.out.println("Your current account balance is: "+balance);
            return false;
        }
        balance -= amount;
        System.out.println("Successfully withdrawn amount "+amount+", current balance is "+balance);
        return true;
    }

    public boolean deposit(float amount) {
        if(amount <=0)
        {
            System.out.println("Enter a positive amount!");
            return false;
        }
        balance += amount;
        System.out.println(amount+" deposited; current balance "+getBalance()+"$");
        return true;
    }

    public boolean requestLoan(float amount) {
        if(loan+ amount > maximumAllowableLoan)
        {
            System.out.println("Can't grant this loan request");
            System.out.println("Maximum allowable loan is: "+maximumAllowableLoan);
            return false;
        }
        reqLoan = amount;
        loanStatus = "pending";
        System.out.println("Loan request successful. Sent for approval");
        return true;
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

}
