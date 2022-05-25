package bank.account;

import java.util.Date;

public abstract class Account {
    protected String name;
    protected String accountType;
    protected Date regDate;
    protected float loan;
    protected float balance;
    protected float reqLoan;
    protected String loanStatus;
    protected float period;
    public static final String STUDENT = "STUDENT";
    public static final String SAVINGS = "SAVINGS";
    public static final String FIXED_DEPOSIT = "FIXEDDEPOSIT";
    public static final String LOAN = "LOAN";


    public Account(String name, String accountType, Date regDate) {
        this.name = name;
        this.accountType = accountType;
        this.regDate = regDate;
        this.period = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public float getLoan() {
        return loan;
    }

    public void setLoan(float loan) {
        this.loan = loan;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getReqLoan() {
        return reqLoan;
    }

    public void setReqLoan(float reqLoan) {
        this.reqLoan = reqLoan;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public float getPeriod() {
        return period;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public boolean withDraw(float amount)
    {
        System.out.println("Invalid operation");
        return false;
    }
    public static Account createDesiredAccount(String name, String accountType, float amount)
    {
        if(accountType.equalsIgnoreCase(STUDENT))
        {
            return StudentAccount.createAccount(name, accountType, amount);
        }else if(accountType.equalsIgnoreCase(FIXED_DEPOSIT))
        {
            return FixedDepositAccount.createAccount(name, accountType, amount);
        }else if(accountType.equalsIgnoreCase(SAVINGS))
        {
            return SavingsAccount.createAccount(name, accountType, amount);
        }else if(accountType.equalsIgnoreCase(LOAN))
        {
            return LoanAccount.createAccount(name, accountType, amount);
        }
        return null;
    }
    public abstract boolean deposit(float amount);
    public abstract boolean requestLoan(float amount);
    public abstract void queryDeposit();
    public abstract void serviceCharge();
    public abstract void yearlyInterest();

}
