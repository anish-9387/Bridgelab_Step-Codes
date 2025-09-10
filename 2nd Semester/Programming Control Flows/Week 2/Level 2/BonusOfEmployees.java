import java.util.*;

// Class creation
class BonusOfEmployees{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for salary and year of service
		int yearOfService;
		double salary, bonus;
		
		// Taking the input from the user
		System.out.print("Enter the salary: ");
		salary = input.nextDouble();
		System.out.print("Enter the year of service: ");
		yearOfService = input.nextInt();
		
		// Calculating bonus and printing the result
		if(yearOfService > 5){
			bonus = 5 / 100.0 * salary;
			System.out.println("The bonus amount is: " + bonus);
		}
		else{
			System.out.println("No bonus for service less than 5 years");
		}
		
		input.close();
	}
}
