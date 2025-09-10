public class Employee{
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;

    private static int totalEmployees=0;
    private static int empCounter=0;

    public Employee(String empName, String department, double baseSalary){
        this.empId=generateEmpId();
        this.empName=empName;
        this.department=department;
        this.baseSalary=baseSalary;
        this.empType="Full-Time";
        totalEmployees++;
    }

    public Employee(String empName, String department, double hourlyRate, int hoursWorked){
        this.empId=generateEmpId();
        this.empName=empName;
        this.department=department;
        this.baseSalary=hourlyRate*hoursWorked;
        this.empType="Part-Time";
        totalEmployees++;
    }

    public Employee(String empName, String department, double contractAmount, boolean isContract){
        this.empId=generateEmpId();
        this.empName=empName;
        this.department=department;
        this.baseSalary=contractAmount;
        this.empType="Contract";
        totalEmployees++;
    }

    public double calculateSalary(double bonus){
        if(empType.equals("Full-Time")){
            return baseSalary+bonus;
        }
        return baseSalary;
    }

    public double calculateSalary(double hourlyRate, int hoursWorked){
        if(empType.equals("Part-Time")){
            return hourlyRate*hoursWorked;
        }
        return baseSalary;
    }

    public double calculateSalary(){
        return baseSalary;
    }

    public double calculateTax(double salary){
        if(empType.equals("Full-Time")){
            return salary*0.2;
        }
        return 0.0;
    }

    public double calculateTax(double salary, boolean isPartTime){
        if(empType.equals("Part-Time")){
            return salary*0.1;
        }
        return 0.0;
    }

    public double calculateTax(double salary, int months){
        if(empType.equals("Contract")){
            return salary*0.05;
        }
        return 0.0;
    }

    public void generatePaySlip(double salary, double tax){
        System.out.println("====== Pay Slip ======");
        System.out.println("Employee ID: "+empId);
        System.out.println("Name: "+empName);
        System.out.println("Department: "+department);
        System.out.println("Type: "+empType);
        System.out.println("Gross Salary: "+salary);
        System.out.println("Tax Deducted: "+tax);
        System.out.println("Net Salary: "+(salary-tax));
        System.out.println("-------------------------");
    }

    public void displayEmployeeInfo(){
        System.out.println("Employee ID: "+empId);
        System.out.println("Name: "+empName);
        System.out.println("Department: "+department);
        System.out.println("Type: "+empType);
        System.out.println("Base Salary: "+baseSalary);
        System.out.println("-------------------------");
    }

    private static String generateEmpId(){
        empCounter++;
        return String.format("E%03d",empCounter);
    }

    public static int getTotalEmployees(){
        return totalEmployees;
    }

    public static void companyPayrollReport(Employee[] employees){
        System.out.println("====== Company Payroll Report ======");
        for(Employee e : employees){
            if(e!=null){
                e.displayEmployeeInfo();
            }
        }
        System.out.println("Total Employees: "+getTotalEmployees());
        System.out.println("==============================");
    }

    public static void main(String[] args){
        Employee[] employees=new Employee[5];

        employees[0]=new Employee("Alice","IT",40000);
        employees[1]=new Employee("Bob","HR",200,80);
        employees[2]=new Employee("Charlie","Finance",50000,true);

        double ftSalary=employees[0].calculateSalary(5000);
        double ftTax=employees[0].calculateTax(ftSalary);
        employees[0].generatePaySlip(ftSalary,ftTax);

        double ptSalary=employees[1].calculateSalary(200,80);
        double ptTax=employees[1].calculateTax(ptSalary,true);
        employees[1].generatePaySlip(ptSalary,ptTax);

        double ctSalary=employees[2].calculateSalary();
        double ctTax=employees[2].calculateTax(ctSalary,6);
        employees[2].generatePaySlip(ctSalary,ctTax);
        companyPayrollReport(employees);
    }
}
