package bank.employees;

import bank.Bank;
import bank.account.Account;

import java.util.List;

public abstract class Employees {
    protected String employeeType;
    protected String name;

    public Employees(String employeeType, String name) {
        this.employeeType = employeeType;
        this.name = name;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void lookUp(String name, List<Account> accountList)
    {
        for(int i=0; i<accountList.size(); i++)
        {
            if(name.equalsIgnoreCase(accountList.get(i).getName()))
            {
                System.out.println(name + "'s current balance "+accountList.get(i).getBalance()+" $");
                return;
            }
        }
        System.out.println("Account does not exist with name: "+name);
    }
    public abstract boolean approveAllLoan(List<Account> accountList);
    public abstract boolean changeInterestRate(String accountType, float newIntRate);
    public abstract void seeInternalFund(Bank bank);
}
