class PersonalAccount{
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    private static int totalAccounts=0;
    private static String bankName;

    public PersonalAccount(String accountHolderName){
        this.accountHolderName=accountHolderName;
        this.accountNumber=generateAccountNumber();
        this.currentBalance=0.0;
        this.totalIncome=0.0;
        this.totalExpenses=0.0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description){
        if(amount>0){
            currentBalance+=amount;
            totalIncome+=amount;
            System.out.println("Income added: "+description+" | Amount: $"+amount);
        }
        else{
            System.out.println("Invalid income amount");
        }
    }

    public void addExpense(double amount, String description){
        if(amount>0 && amount<=currentBalance){
            currentBalance-=amount;
            totalExpenses+=amount;
            System.out.println("Expense added: "+description+" | Amount: $"+amount);
        }
        else{
            System.out.println("Invalid expense amount or insufficient balance");
        }
    }

    public double calculateSavings(){
        return (totalIncome-totalExpenses);
    }

    public void displayAccountSummary(){
        System.out.println("====== Account Summary ======");
        System.out.println("Bank Name: "+bankName);
        System.out.println("Account Holder: "+accountHolderName);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Current Balance: $"+currentBalance);
        System.out.println("Total Income: $"+totalIncome);
        System.out.println("Total Expenses: $"+totalExpenses);
        System.out.println("Total Savings: $"+calculateSavings());
        System.out.println("========================\n");
    }

    public static void setBankName(String name){
        bankName=name;
    }

    public static int getTotalAccounts(){
        return totalAccounts;
    }

    private static String generateAccountNumber(){
        return "AC"+String.format("%05d",totalAccounts+1);
    }
}

public class PersonalFinanceManager{
    public static void main(String[] args){
        PersonalAccount.setBankName("SmartBank");

        PersonalAccount acc1=new PersonalAccount("Alice");
        PersonalAccount acc2=new PersonalAccount("Bob");
        PersonalAccount acc3=new PersonalAccount("Charlie");

        acc1.addIncome(2000,"Salary");
        acc1.addExpense(500,"Rent");
        acc1.addExpense(200,"Groceries");

        acc2.addIncome(1500,"Freelance Project");
        acc2.addExpense(300,"Shopping");
        acc2.addExpense(100,"Food Delivery");

        acc3.addIncome(3000,"Business Profit");
        acc3.addExpense(1200,"Office Rent");
        acc3.addExpense(800,"Supplies");

        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        System.out.println("Bank Name (Shared): "+"SmartBank");
        System.out.println("Total Accounts Created: "+PersonalAccount.getTotalAccounts());
    }
}
