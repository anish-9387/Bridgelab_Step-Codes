public class BankAccount{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    private static int totalAccounts=0;
    private static int accountCounter=0;

    public BankAccount(String accountHolderName, double initialDeposit){
        if(initialDeposit<0){
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }
        this.accountHolderName=accountHolderName;
        this.balance=initialDeposit;
        this.accountNumber=generateAccountNumber();
        totalAccounts++;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println(accountHolderName+" deposited "+amount+". New Balance: "+balance);
        }
        else{
            System.out.println("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Withdrawal amount must be positive");
        }
        else if(amount>balance){
            System.out.println("Insufficient funds for "+accountHolderName);
        }
        else{
            balance-=amount;
            System.out.println(accountHolderName+" withdrew "+amount+". New Balance: "+balance);
        }
    }

    public void checkBalance(){
        System.out.println(accountHolderName+" ("+accountNumber+") Balance: "+balance);
    }

    public void displayAccountInfo(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+accountHolderName);
        System.out.println("Balance: "+balance);
        System.out.println("-----------------------------");
    }

    public static int getTotalAccounts(){
        return totalAccounts;
    }

    private static String generateAccountNumber(){
        accountCounter++;
        return String.format("ACC%03d", accountCounter);
    }

    public static void main(String[] args){
        BankAccount[] accounts=new BankAccount[5];
        int index=0;

        accounts[index++]=new BankAccount("Alice",1000);
        accounts[index++]=new BankAccount("Bob",500);
        accounts[index++]=new BankAccount("Charlie",2000);

        accounts[0].deposit(500);
        accounts[1].withdraw(200);
        accounts[2].withdraw(2500);

        System.out.println("\n====== Account Details ======");
        for(int i=0; i<index; i++){
            accounts[i].displayAccountInfo();
        }

        accounts[0].checkBalance();
        accounts[1].checkBalance();
        accounts[2].checkBalance();
        System.out.println("\nTotal Accounts Created: "+BankAccount.getTotalAccounts());
    }
}
