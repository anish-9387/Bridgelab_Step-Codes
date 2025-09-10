import java.util.Arrays;

abstract class Employee {
    protected String empId;
    protected String empName;
    protected String department;
    protected String designation;
    protected double baseSalary;
    protected String joinDate;
    protected boolean[] attendanceRecord;
    protected int performanceScore;
    protected int leavesTaken;

    public static int totalEmployees = 0;
    public static String companyName = "Acme Corp";
    public static double totalSalaryExpense = 0.0;
    public static int workingDaysPerMonth = 30;

    public Employee(String empId, String empName, String department, String designation,
                    double baseSalary, String joinDate, int performanceScore) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.performanceScore = performanceScore;
        this.attendanceRecord = new boolean[workingDaysPerMonth];
        Arrays.fill(this.attendanceRecord, true);
        this.leavesTaken = 0;
        totalEmployees++;
    }

    public void markAttendance(int day, boolean present) {
        if (day < 1 || day > workingDaysPerMonth) {
            System.out.println("Invalid day: " + day);
            return;
        }
        attendanceRecord[day - 1] = present;
    }

    public void requestLeave(int day) {
        if (day < 1 || day > workingDaysPerMonth) {
            System.out.println("Invalid day for leave: " + day);
            return;
        }
        if (!attendanceRecord[day - 1]) {
            System.out.println(empName + " already absent on day " + day);
            return;
        }
        attendanceRecord[day - 1] = false;
        leavesTaken++;
        System.out.println(empName + " leave approved for day " + day);
    }

    public int getPresentDays() {
        int p = 0;
        for (boolean b : attendanceRecord) if (b) p++;
        return p;
    }

    public abstract double calculateSalary();

    public double calculateBonus() {
        if (performanceScore >= 80) return baseSalary * 0.20;
        if (performanceScore >= 60) return baseSalary * 0.10;
        if (performanceScore >= 40) return baseSalary * 0.05;
        return 0.0;
    }

    public void generatePaySlip() {
        double gross = calculateSalary();
        double bonus = calculateBonus();
        double net = gross + bonus;
        totalSalaryExpense += net;
        System.out.println("----- PaySlip -----");
        System.out.println("Employee: " + empName + " (" + empId + ")");
        System.out.println("Designation: " + designation + " | Dept: " + department);
        System.out.println("BaseSalary: " + String.format("%.2f", baseSalary));
        System.out.println("Present Days: " + getPresentDays() + "/" + workingDaysPerMonth);
        System.out.println("Leaves Taken: " + leavesTaken);
        System.out.println("Gross Pay (after attendance adj): " + String.format("%.2f", gross));
        System.out.println("Performance Bonus: " + String.format("%.2f", bonus));
        System.out.println("Net Pay: " + String.format("%.2f", net));
        System.out.println("-------------------\n");
    }

    public String brief() {
        return empId + ":" + empName + " | " + department + " | " + designation;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String empId, String empName, String department, String designation,
                            double baseSalary, String joinDate, int performanceScore) {
        super(empId, empName, department, designation, baseSalary, joinDate, performanceScore);
    }

    @Override
    public double calculateSalary() {
        int present = getPresentDays();
        double prorated = (baseSalary / workingDaysPerMonth) * present;
        return prorated;
    }
}

class PartTimeEmployee extends Employee {
    private double hoursWorkedThisMonth;

    public PartTimeEmployee(String empId, String empName, String department, String designation,
                            double hourlyRate, String joinDate, int performanceScore) {
        super(empId, empName, department, designation, hourlyRate, joinDate, performanceScore);
        this.hoursWorkedThisMonth = 0.0;
    }

    public void addHours(double hours) {
        if (hours > 0) this.hoursWorkedThisMonth += hours;
    }

    @Override
    public double calculateSalary() {
        double hourlyRate = baseSalary;
        double pay = hourlyRate * hoursWorkedThisMonth;
        if (getPresentDays() < 10) pay *= 0.9;
        return pay;
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee(String empId, String empName, String department, String designation,
                            double contractAmount, String joinDate, int performanceScore) {
        super(empId, empName, department, designation, contractAmount, joinDate, performanceScore);
    }

    @Override
    public double calculateSalary() {
        int absentDays = workingDaysPerMonth - getPresentDays();
        double penalty = 0.0;
        if (absentDays > 5) {
            penalty = (absentDays - 5) * (baseSalary * 0.01);
        }
        return Math.max(0, baseSalary - penalty);
    }
}

class Department {
    String deptId;
    String deptName;
    Employee manager;
    Employee[] employees;
    int empCount;
    double budget;

    public Department(String deptId, String deptName, Employee manager, int capacity, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.employees = new Employee[capacity];
        this.empCount = 0;
        this.budget = budget;
    }

    public boolean addEmployee(Employee e) {
        if (empCount >= employees.length) return false;
        employees[empCount++] = e;
        return true;
    }

    public double getDepartmentExpense() {
        double sum = 0.0;
        for (int i = 0; i < empCount; i++) {
            double gross = employees[i].calculateSalary() + employees[i].calculateBonus();
            sum += gross;
        }
        return sum;
    }

    public void displayDeptSummary() {
        System.out.println("Department: " + deptName + " (" + deptId + ")");
        System.out.println("Manager: " + (manager != null ? manager.empName : "None"));
        System.out.println("Employees:");
        for (int i = 0; i < empCount; i++) System.out.println(" - " + employees[i].brief());
        System.out.println("Dept Expense (est.): " + String.format("%.2f", getDepartmentExpense()));
        System.out.println("Budget: " + String.format("%.2f", budget));
        System.out.println();
    }
}

class CompanyReports {
    public static double calculateCompanyPayroll(Department[] depts) {
        double total = 0.0;
        for (Department d : depts) {
            if (d == null) continue;
            total += d.getDepartmentExpense();
        }
        Employee.totalSalaryExpense = total;
        return total;
    }

    public static void getDepartmentWiseExpenses(Department[] depts) {
        System.out.println("Department-wise expenses:");
        for (Department d : depts) {
            if (d == null) continue;
            System.out.println(d.deptName + ": " + String.format("%.2f", d.getDepartmentExpense()));
        }
        System.out.println();
    }

    public static void getAttendanceReport(Employee[] allEmployees) {
        System.out.println("Attendance report (present days/month):");
        for (Employee e : allEmployees) {
            if (e == null) continue;
            System.out.println(e.empName + " (" + e.empId + "): " + e.getPresentDays() + "/" + Employee.workingDaysPerMonth);
        }
        System.out.println();
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee.companyName = "Nimbus Solutions";
        Employee.workingDaysPerMonth = 30;

        FullTimeEmployee ft1 = new FullTimeEmployee("E001", "Alice", "Engineering", "Senior Engineer", 60000, "2020-03-01", 85);
        FullTimeEmployee ft2 = new FullTimeEmployee("E002", "Bob", "Engineering", "Engineer", 45000, "2021-05-15", 72);
        PartTimeEmployee pt1 = new PartTimeEmployee("E003", "Charlie", "Support", "Support Exec", 200, "2024-01-10", 65);
        ContractEmployee ct1 = new ContractEmployee("E004", "Dana", "Design", "Contractor", 30000, "2025-02-01", 55);

        Department eng = new Department("D01", "Engineering", ft1, 10, 300000);
        eng.addEmployee(ft1);
        eng.addEmployee(ft2);

        Department support = new Department("D02", "Support", pt1, 5, 80000);
        support.addEmployee(pt1);

        Department design = new Department("D03", "Design", ct1, 5, 100000);
        design.addEmployee(ct1);

        Department[] depts = {eng, support, design};

        for (int d = 1; d <= 30; d++) {
            if (d == 3 || d == 4) ft2.markAttendance(d, false);
            if (d == 10) pt1.markAttendance(d, false);
            if (d == 5 || d == 6 || d == 7) ct1.markAttendance(d, false);
        }

        pt1.addHours(80);

        ft1.requestLeave(20);
        ft2.requestLeave(21);

        Employee[] allEmps = {ft1, ft2, pt1, ct1};
        for (Employee e : allEmps) e.generatePaySlip();

        eng.displayDeptSummary();
        support.displayDeptSummary();
        design.displayDeptSummary();

        CompanyReports.getAttendanceReport(allEmps);
        CompanyReports.getDepartmentWiseExpenses(depts);
        double totalPayroll = CompanyReports.calculateCompanyPayroll(depts);
        System.out.println("Total Company Payroll (est.): " + String.format("%.2f", totalPayroll));
    }
}
