import java.util.*;

// Class creation
class SimpleInterest{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for principal, rate and time
		double principal, rate, time;
		
		// Taking the input from the user
		System.out.print("Enter the principal: ");
		principal = input.nextDouble();
		System.out.print("Enter the rate: ");
		rate = input.nextDouble();
		System.out.print("Enter the time: ");
		time = input.nextDouble();
		
		// Calculating the simple interest
		double si = principal * rate * time / 100;
		
		// Printing the simple interest
		System.out.println("The Simple Interest is " + si + " for Principal " + principal + ", Rate of interest " + rate + " and Time " + time);
		
		input.close();
	}
}
		