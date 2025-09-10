import java.util.*;

// Class creation
class SimpleInterest{	
	// Method to calcualte the simple interest
	public static double calculateSimpleInterest(double principal, double rate, int time){
		return (principal * rate * time / 100);
	}
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for principal, rate and time
		System.out.print("Enter the principal amount: ");
		double principal = input.nextDouble();
		System.out.print("Enter the rate of interest: ");
		double rate = input.nextDouble();
		System.out.print("Enter the time period: ");
		int time = input.nextInt();
		
		// Calculating simple interest and printing it
		double si = calculateSimpleInterest(principal,rate,time);
		System.out.println("The Simple Interest is " + si + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
		
		input.close();
	}
}
