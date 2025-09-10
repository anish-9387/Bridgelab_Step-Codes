// Class creation
public class BonusCalculator{
    // Method to generate employee salaries and years of service
    public int[][] generateEmployeeData(){
        int[][] employeeData = new int[10][2];

        for(int i=0; i<10; i++){
            int salary = (int)(Math.random() * 90000) + 10000;
            int years = (int)(Math.random() * 11);
            employeeData[i][0] = salary;
            employeeData[i][1] = years;
        }
        return employeeData;
    }

    // Method to calculate the new salary and bonus
    public double[][] calculateBonusAndNewSalary(int[][] employeeData){
        double[][] newSalaryData = new double[10][2];

        for(int i=0; i<10; i++){
            int salary = employeeData[i][0];
            int years = employeeData[i][1];

            double bonusPercent = (years > 5) ? 0.05 : 0.02;
            double bonus = bonusPercent * salary;
            double newSalary = salary + bonus;

            newSalaryData[i][0] = bonus;
            newSalaryData[i][1] = newSalary;
        }
        return newSalaryData;
    }

    // Method to Calculate the sum of the Old Salary, the sum of the New Salary, and the Total Bonus Amount
    public void displayReport(int[][] oldData, double[][] newData){
        double totalOld = 0, totalBonus = 0, totalNew = 0;

        System.out.printf("%-10s%-15s%-15s%-15s%-15s\n","Emp ID","Old Salary","Years","Bonus","New Salary");
        System.out.println("------------------------------------------------------------------------");

        for(int i=0; i<10; i++){
            int salary = oldData[i][0];
            int years = oldData[i][1];
            double bonus = newData[i][0];
            double newSalary = newData[i][1];

            System.out.printf("%-10d%-15d%-15d%-15.2f%-15.2f\n",(i + 1),salary,years,bonus,newSalary);

            totalOld += salary;
            totalBonus += bonus;
            totalNew += newSalary;
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-10s%-15.2f%-15s%-15.2f%-15.2f\n","Total",totalOld,"",totalBonus,totalNew);
    }

    public static void main(String[] args){
		BonusCalculator obj = new BonusCalculator();
		
        int[][] employeeData = obj.generateEmployeeData();
        double[][] updatedData = obj.calculateBonusAndNewSalary(employeeData);
        obj.displayReport(employeeData, updatedData);
    }
}
