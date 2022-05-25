package bank.employees;

import bank.Bank;
import bank.account.Account;

import java.util.List;

public class Officer extends Employees{


    public Officer(String employeeType, String name) {
        super(employeeType, name);
    }

    @Override
    public boolean approveAllLoan(List<Account> accountList)
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
            }
        }
        return true;
    }

    @Override
    public boolean changeInterestRate(String accountType, float newIntRate) {
        System.out.println("You don't have permission for this operation");
        return false;
    }

    @Override
    public void seeInternalFund(Bank bank) {
        System.out.println("You don't have permission for this operation");
    }
}
