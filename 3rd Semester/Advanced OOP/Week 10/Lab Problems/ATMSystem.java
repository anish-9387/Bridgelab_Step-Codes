import java.util.Scanner;

class ATM{
    private double balance;

    public ATM(double initialBalance){
        this.balance=initialBalance;
    }

    public void withdrawMoney(double amount){
        if(amount>balance){
            System.out.println("Insufficient balance!");
        }
        else{
            balance-=amount;
            System.out.println("Withdrawal successful! Remaining balance: Rs."+balance);
        }
    }

    public void depositMoney(double amount){
        balance+=amount;
        System.out.println("Deposit successful! New balance: Rs."+balance);
    }

    public void checkBalance(){
        System.out.println("Your current balance is: Rs."+balance);
    }
}

class User{
    private String name;
    private ATM atm;

    public User(String name, ATM atm){
        this.name=name;
        this.atm=atm;
    }

    public void performOperations(){
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            System.out.println("\nWelcome, "+name+"! Choose an option:");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter amount to withdraw: Rs.");
                    double w=sc.nextDouble();
                    atm.withdrawMoney(w);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: Rs.");
                    double d=sc.nextDouble();
                    atm.depositMoney(d);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice!=4);
        sc.close();
    }
}

public class ATMSystem{
    public static void main(String[] args){
        ATM atm=new ATM(5000.00);
        User user=new User("Anish",atm);
        user.performOperations();
    }
}
