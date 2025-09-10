import java.util.*;

// Class creation
class TotalIncome{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating varibles of salary and bonus
		double salary, bonus;
		
		// Taking the inputs from the user
		System.out.print("Enter the salary: ");
		salary = input.nextDouble();
		
		System.out.print("Enter the bonus: ");
		bonus = input.nextDouble();
		
		// Calculating the total income
		double totalIncome = salary + bonus;
		
		// Printing the result
		System.out.println("The salary is INR " + salary + " and bonus is INR " + bonus + ". Hence, total income is INR " + totalIncome);
		
		input.close();
	}
}
