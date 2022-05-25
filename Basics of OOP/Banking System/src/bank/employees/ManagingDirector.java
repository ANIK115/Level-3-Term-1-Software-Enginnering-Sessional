package bank.employees;

import bank.Bank;
import bank.account.Account;
import bank.account.FixedDepositAccount;
import bank.account.SavingsAccount;
import bank.account.StudentAccount;

import java.util.List;

public class ManagingDirector extends Employees{


    public ManagingDirector(String employeeType, String name) {
        super(employeeType, name);
    }

    @Override
    public boolean approveAllLoan(List<Account>accountList)
    {
        for(int i=0; i<accountList.size(); i++)
        {
            Account account = accountList.get(i);
            if(account.getLoanStatus().equalsIgnoreCase("pending"))
            {
                account.setLoanStatus("Accepted");
                account.setLoan(account.getLoan()+account.getReqLoan());
                account.setBalance(account.getBalance()+account.getReqLoan());
                account.setReqLoan(0);
                System.out.println("Loan for "+account.getName()+" approved");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeInterestRate(String accountType, float newIntRate)
    {
        if(accountType.equalsIgnoreCase(Account.SAVINGS))
        {
            SavingsAccount.setInterestRate(newIntRate);
            return true;
        }else if(accountType.equalsIgnoreCase(Account.STUDENT))
        {
            StudentAccount.changeInterestRate(newIntRate);
            return true;
        }else if(accountType.equalsIgnoreCase(Account.FIXED_DEPOSIT))
        {
            FixedDepositAccount.setInterestRate(newIntRate);
            return true;
        }else if(accountType.equalsIgnoreCase(Account.LOAN))
        {

            return true;
        }else {
            return false;
        }
    }

    @Override
    public void seeInternalFund(Bank bank)
    {
        System.out.println("Bank internal fund "+bank.getFund());
    }
}
