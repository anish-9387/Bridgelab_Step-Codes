import java.util.*;

class Account{
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited Rs."+amount+". New balance: Rs."+balance);
    }

    public void withdraw(double amount){
        if(amount>balance){
            System.out.println("Insufficient balance!");
        }
        else{
            balance-=amount;
            System.out.println("Withdrawn Rs."+amount+". Remaining balance: Rs."+balance);
        }
    }

    public void displayBalance(){
        System.out.println("Account Number: "+accountNumber+", Balance: Rs."+balance);
    }
}

class Customer{
    private String name;
    private String customerId;
    private List<Account> accounts=new ArrayList<>();

    public Customer(String name, String customerId){
        this.name=name;
        this.customerId=customerId;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void viewAccounts(){
        System.out.println("Customer: "+name);
        for(Account acc : accounts){
            acc.displayBalance();
        }
    }
}

class Bank{
    private String bankName;
    private List<Customer> customers=new ArrayList<>();

    public Bank(String bankName){
        this.bankName=bankName;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void displayAllCustomers(){
        System.out.println("Bank: "+bankName);
        for(Customer c : customers){
            c.viewAccounts();
        }
    }
}

public class BankSystem{
    public static void main(String[] args){
        Bank bank=new Bank("SRM National Bank");

        Customer c1=new Customer("Anish","C101");
        Customer c2=new Customer("Priya","C102");

        Account a1=new Account("A1001",5000);
        Account a2=new Account("A1002",10000);
        Account a3=new Account("A1003",8000);

        c1.addAccount(a1);
        c1.addAccount(a2);
        c2.addAccount(a3);

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        bank.displayAllCustomers();
    }
}
