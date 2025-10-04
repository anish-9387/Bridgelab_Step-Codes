abstract class Employee{
    protected String name;
    protected double salary;

    public Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }

    public abstract double calculateBonus();

    public void displayDetails(){
        System.out.println("Employee Name: "+name);
        System.out.println("Base Salary: Rs."+salary);
    }
}

interface Payable{
    void generatePaySlip();
}

class Manager extends Employee implements Payable{
    private String department;

    public Manager(String name, double salary, String department){
        super(name,salary);
        this.department=department;
    }

    @Override
    public double calculateBonus(){
        double bonus=salary*0.15;
        return bonus;
    }

    @Override
    public void generatePaySlip(){
        double bonus=calculateBonus();
        double totalPay=salary+bonus;
        System.out.println("Generating Pay Slip......");
        System.out.println("Department: "+department);
        System.out.println("Base Salary: Rs."+salary);
        System.out.println("Bonus: Rs."+bonus);
        System.out.println("Total Pay: Rs."+totalPay);
    }

    public void showEmployeeInfo(){
        displayDetails();
        System.out.println("Department: "+department);
    }
}

public class PayrollTest{
    public static void main(String[] args){
        Manager manager=new Manager("Anish",80000,"IT Department");

        manager.showEmployeeInfo();
        System.out.println();
        manager.generatePaySlip();
    }
}
