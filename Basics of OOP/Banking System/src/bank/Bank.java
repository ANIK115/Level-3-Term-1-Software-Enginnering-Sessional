package bank;

import bank.account.Account;
import bank.employees.Cashier;
import bank.employees.Employees;
import bank.employees.ManagingDirector;
import bank.employees.Officer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private float fund;
    private List<Account> accounts;
    private List<Employees>employees;
    private int yearCount;
    private Employees MD;
    private Employees O1, O2;
    private Employees C1, C2, C3, C4, C5;
    private static final String OFFICER = "OFFICER";
    private static final String MANAGING_DIRECTOR = "MANAGING DIRECTOR";
    private static final String CASHIER = "CASHIER";
    private Account currentAccount;
    private Employees currentEmployee;
    private boolean loanPending;

    public Bank() {
        fund = 1000000;
        accounts = new ArrayList<>();
        employees = new ArrayList<>();
        yearCount = 0;
        employees.add(new ManagingDirector(MANAGING_DIRECTOR, "MD"));
        employees.add(new Officer(OFFICER, "O1"));
        employees.add(new Officer(OFFICER, "O2"));
        employees.add(new Cashier(CASHIER, "C1"));
        employees.add(new Cashier(CASHIER, "C2"));
        employees.add(new Cashier(CASHIER, "C3"));
        employees.add(new Cashier(CASHIER, "C4"));
        employees.add(new Cashier(CASHIER, "C5"));

        currentAccount = null;
        currentEmployee = null;
        loanPending = false;
        System.out.println("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created");
    }

    public float getFund() {
        return fund;
    }

    public void setFund(float fund) {
        this.fund = fund;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getYearCount() {
        return yearCount;
    }

    public void setYearCount(int yearCount) {
        this.yearCount = yearCount;
    }

    public Employees giveEmployee(String name)
    {
        for(Employees e : employees)
        {
            if(e.getName().equalsIgnoreCase(name))
            {
                return e;
            }
        }
        return null;
    }

    public Account giveAccount(String name)
    {
        for(Account a: accounts)
        {
            if(a.getName().equalsIgnoreCase(name))
            {
                return a;
            }
        }
        return null;
    }

    public void updatePeriod()
    {
        for(Account a : accounts)
        {
            a.setPeriod(a.getPeriod() + 1);
            a.yearlyInterest();
            a.serviceCharge();
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            String command = scan.nextLine();
            String[] commands = command.split(" ");
            if(commands[0].equalsIgnoreCase("Create"))
            {
                String name = commands[1];
                boolean flag = false;
                for(Account ac : bank.accounts)
                {
                    if(ac.getName().equalsIgnoreCase(name))
                    {
                        flag = true;
                        System.out.println("Name already exists!");
                        break;
                    }
                }
                if(!flag)
                {
                    Account account = Account.createDesiredAccount(name, commands[2], Float.parseFloat(commands[3]));
                    if(account == null)
                    {
                        System.out.println("Cannot create this account!");
                    }else
                    {
                        if(commands[2].equalsIgnoreCase(Account.LOAN))
                        {
                            bank.fund -= Float.parseFloat(commands[3]);
                        }else
                        {
                            bank.fund += Float.parseFloat(commands[3]);
                        }
                        bank.currentAccount = account;
                        bank.accounts.add(account);
                        System.out.println(commands[2]+" account for "+name+" created; initial balance "+account.getBalance()+"$");
                    }
                }
            }else if(commands[0].equalsIgnoreCase("deposit"))
            {
                if(bank.currentAccount == null)
                {
                    System.out.println("Invalid operation");
                }else
                {
                    boolean b = bank.currentAccount.deposit(Float.parseFloat(commands[1]));
                    if(b)
                    {
                        bank.fund += Float.parseFloat(commands[1]);
                    }
                }
            }else if(commands[0].equalsIgnoreCase("Withdraw"))
            {
                if(bank.currentAccount == null)
                {
                    System.out.println("Invalid operation");
                }else
                {
                    boolean b = bank.currentAccount.withDraw(Float.parseFloat(commands[1]));
                    if(b)
                    {
                        bank.fund -= Float.parseFloat(commands[1]);
                    }
                }
            }else if(commands[0].equalsIgnoreCase("Query"))
            {
                bank.currentAccount.queryDeposit();
            }else if(commands[0].equalsIgnoreCase("Request"))
            {
                boolean b = bank.currentAccount.requestLoan(Float.parseFloat(commands[1]));
                if(!b)
                {
                    System.out.println("Can't complete request!");
                }else
                {
                    bank.loanPending = true;
                    if(bank.currentAccount.getAccountType().equalsIgnoreCase(Account.LOAN))
                    {
                        bank.fund -= Float.parseFloat(commands[1]);
                    }
                }
            }else if(commands[0].equalsIgnoreCase("Close"))
            {
                if(bank.currentAccount != null) {
                    System.out.println("Transaction closed for " + bank.currentAccount.getName());
                    bank.currentAccount = null;
                }else if(bank.currentEmployee != null)
                {
                    System.out.println("Operations for "+bank.currentEmployee.getName()+" closed");
                    bank.currentEmployee = null;
                }else
                {
                    System.out.println("No user was active!");
                }

            }else if(commands[0].equalsIgnoreCase("Open"))
            {
                //search for employee
                String name = commands[1];
                bank.currentEmployee = bank.giveEmployee(name);
                if(bank.currentEmployee != null)
                {
                    System.out.print(bank.currentEmployee.getName()+" active");
                    if(bank.loanPending)
                    {
                        System.out.println(", there are loan approvals pending");
                    }else
                    {
                        System.out.println();
                    }
                }else //search for account
                {
                    bank.currentAccount = bank.giveAccount(name);
                    if(bank.currentAccount != null)
                        System.out.println("Welcome back, "+bank.currentAccount.getName());
                    else
                        System.out.println("No one exists with this name: "+name);
                }
            }else if(commands[0].equalsIgnoreCase("Approve") && commands[1].equalsIgnoreCase("loan"))
            {
                if(bank.currentEmployee == null)
                {
                    System.out.println("You don't have permission for this operation");
                    continue;
                }
                bank.currentEmployee.approveAllLoan(bank.accounts);
                bank.loanPending = false;
            }else if(commands[0].equalsIgnoreCase("Change"))
            {
                if(bank.currentEmployee == null)
                {
                    System.out.println("You don't have permission for this operation");
                    continue;
                }
                String type = commands[1];
                float rate = Float.parseFloat(commands[2]);
                bank.currentEmployee.changeInterestRate(type, rate);
            }else if(commands[0].equalsIgnoreCase("Lookup"))
            {
                if(bank.currentEmployee == null)
                {
                    System.out.println("You don't have permission for this operation");
                    continue;
                }
                bank.currentEmployee.lookUp(commands[1], bank.accounts);
            }else if(commands[0].equalsIgnoreCase("See"))
            {
                if(bank.currentEmployee == null)
                {
                    System.out.println("You don't have permission for this operation");
                    continue;
                }
                bank.currentEmployee.seeInternalFund(bank);
            }else if(commands[0].equalsIgnoreCase("INC"))
            {
                bank.updatePeriod();
                bank.setYearCount(bank.getYearCount()+1);
                System.out.println("1 year passed");
            }else if(commands[0].equalsIgnoreCase("end"))
            {
                break;
            }else
            {
                System.out.println("Invalid command");
            }
        }
    }
}
