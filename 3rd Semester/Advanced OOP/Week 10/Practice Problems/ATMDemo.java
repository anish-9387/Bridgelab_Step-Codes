class BankAccount{
    private String accountNumber;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, double balance, int pin){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.pin=pin;
    }

    public boolean validatePin(int enteredPin){
        return enteredPin==pin;
    }

    public void debit(double amount){
        if(amount<=balance){
            balance-=amount;
            System.out.println("Rs."+amount+" withdrawn. Remaining balance: Rs."+balance);
        }
        else{
            System.out.println("Insufficient balance!");
        }
    }
}

class ATM{
    private BankAccount linkedAccount;

    public ATM(BankAccount linkedAccount){
        this.linkedAccount=linkedAccount;
    }

    public void withdraw(int enteredPin, double amount){
        System.out.println("\nATM: Validating PIN...");
        if(linkedAccount.validatePin(enteredPin)){
            System.out.println("ATM: PIN verified successfully");
            linkedAccount.debit(amount);
            System.out.println("ATM: Dispensing cash...");
            System.out.println("ATM: Transaction successful!");
        }
        else{
            System.out.println("Invalid PIN. Transaction failed");
        }
    }
}

class Customer{
    private String name;
    private ATM atm;

    public Customer(String name, ATM atm){
        this.name=name;
        this.atm=atm;
    }

    public void performWithdrawal(int pin, double amount){
        System.out.println("\n"+name+" is requesting withdrawal of Rs."+amount+"...");
        atm.withdraw(pin,amount);
    }
}

public class ATMDemo{
    public static void main(String[] args){
        BankAccount account=new BankAccount("AC12345",50000.0,1234);

        ATM atm=new ATM(account);

        Customer customer=new Customer("Rahul",atm);

        customer.performWithdrawal(1234,10000);

        customer.performWithdrawal(9999,5000);
    }
}
