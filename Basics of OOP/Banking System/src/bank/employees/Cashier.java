package bank.employees;

import bank.Bank;
import bank.account.Account;

import java.util.List;

public class Cashier extends Employees{

    public Cashier(String employeeType, String name) {
        super(employeeType, name);
    }

    @Override
    public boolean approveAllLoan(List<Account> accountList) {
        System.out.println("You don't have permission for this operation");
        return false;
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
