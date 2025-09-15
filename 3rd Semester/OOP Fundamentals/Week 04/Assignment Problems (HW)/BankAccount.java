import java.util.Random;

public class BankAccount{
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(){
        this.accountHolder="Unknown";
        this.accountNumber=new Random().nextInt(10000)+1000;
        this.balance=0.0;
    }

    BankAccount(String accountHolder){
        this.accountHolder=accountHolder;
        this.accountNumber=new Random().nextInt(10000)+1000;
        this.balance=0.0;
    }

    BankAccount(String accountHolder, double balance){
        this.accountHolder=accountHolder;
        this.accountNumber=new Random().nextInt(10000)+1000;
        this.balance=balance;
    }

    void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited ₹"+amount+" into "+accountHolder+"'s account");
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount){
        if(amount>0 && balance>=amount){
            balance-=amount;
            System.out.println("Withdrawn ₹"+amount+" from "+accountHolder+"'s account");
        }
        else{
            System.out.println("Insufficient balance or invalid withdrawal");
        }
    }

    void displayAccount(){
        System.out.println("Account Details:");
        System.out.println("Account Holder: "+accountHolder);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: ₹"+balance);
        System.out.println("-------------------------");
    }

    public static void main(String[] args){
        BankAccount a1=new BankAccount();

        BankAccount a2=new BankAccount("Alice");

        BankAccount a3=new BankAccount("Bob",5000.0);

        a1.deposit(1000);
        a1.withdraw(500);

        a2.deposit(2000);
        a2.withdraw(2500);

        a3.deposit(1500);
        a3.withdraw(2000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}
