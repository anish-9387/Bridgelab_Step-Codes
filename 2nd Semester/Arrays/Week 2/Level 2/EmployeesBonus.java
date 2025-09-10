import java.util.*;

// Class creation
public class EmployeesBonus{
    public static void main(String[] args){
		
        Scanner input = new Scanner(System.in);
        
		// Creation of arrays for salaries, years of service, bonuses and new salaries
        int numOfEmployees = 10;
        double[] salaries = new double[numOfEmployees];
        double[] yearsOfService = new double[numOfEmployees];
        double[] bonuses = new double[numOfEmployees];
        double[] newSalaries = new double[numOfEmployees];
        
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        // Taking salaries and years of service from the user
		for(int i=0; i<numOfEmployees; i++){
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            salaries[i] = input.nextDouble();
            
            while(salaries[i] <= 0){
                System.out.print("Invalid input. Enter a valid salary for employee " + (i + 1) + ": ");
                salaries[i] = input.nextDouble();
            }

            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            yearsOfService[i] = input.nextDouble();
            
            while(yearsOfService[i] < 0){
                System.out.print("Invalid input. Enter valid years of service for employee " + (i + 1) + ": ");
                yearsOfService[i] = input.nextDouble();
            }
        }
        
		// Calculating bonuses and new salaries
        for(int i=0; i<numOfEmployees; i++){
            if(yearsOfService[i] > 5){
                bonuses[i] = salaries[i] * 0.05;
            }
			else {
                bonuses[i] = salaries[i] * 0.02;
            }
            newSalaries[i] = salaries[i] + bonuses[i];
            
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        
		// Printing the bonus report and total old and new salaries
        System.out.println("\n---- Bonus Report ----");
        for(int i=0; i<numOfEmployees; i++){
            System.out.printf("Employee %d - Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f\n",
            (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }
        
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);        
        input.close();
    }
}
