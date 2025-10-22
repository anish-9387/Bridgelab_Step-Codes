import java.util.*;

class Account{
    String accountNumber;
    double balance;

    public Account(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void displayAccount(){
        System.out.println("Account: "+accountNumber+", Balance: Rs."+balance);
    }
}

class Customer{
    String name;
    String customerId;
    List<Account> accounts=new ArrayList<>();

    public Customer(String name, String customerId){
        this.name=name;
        this.customerId=customerId;
    }

    public void addAccount(Account acc){
        accounts.add(acc);
    }

    public void displayCustomer(){
        System.out.println("Customer: "+name+" ("+customerId+")");
        for(Account acc : accounts){
            acc.displayAccount();
        }
    }
}

class Bank{
    String bankName;
    List<Customer> customers=new ArrayList<>();

    public Bank(String bankName){
        this.bankName=bankName;
    }

    public void addCustomer(Customer cust){
        customers.add(cust);
    }

    public void displayBankDetails(){
        System.out.println("Bank Name: "+bankName);
        System.out.println("------ Customer Details ------");
        for(Customer c : customers){
            c.displayCustomer();
        }
    }
}

public class ObjectDiagramDemo{
    public static void main(String[] args){
        Account acc1=new Account("A1001",5000);
        Account acc2=new Account("A1002",7000);
        Account acc3=new Account("A1003",9000);

        Customer cust1=new Customer("Anish","C101");
        Customer cust2=new Customer("Himanshi","C102");

        cust1.addAccount(acc1);
        cust1.addAccount(acc2);
        cust2.addAccount(acc3);

        Bank bank1=new Bank("SRM National Bank");
        bank1.addCustomer(cust1);
        bank1.addCustomer(cust2);

        bank1.displayBankDetails();
    }
}
