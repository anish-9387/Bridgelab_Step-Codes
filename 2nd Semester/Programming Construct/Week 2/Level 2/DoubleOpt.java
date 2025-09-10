import java.util.*;
// Class creation
class DoubleOpt{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating three variables
		double a, b, c;
		
		// Taking input from user
		System.out.print("Enter three numbers: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		// Calculating and printing the integer operations
		double result1 = a + b * c;	
		double result2 = a * b + c;	
		double result3 = c + a / b;	
		double result4 = a % b + c;
		
		// Printing the results
		System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + " and " + result4);
		
		input.close();
	}
}
