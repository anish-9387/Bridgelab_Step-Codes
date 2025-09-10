import java.util.*;

// Class creation
class FindingQuotientRemainder{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating variables for the 2 numbers
		int number1, number2;
		
		// Taking the input from the user
		System.out.print("Enter first number: ");
		number1 = input.nextInt();
		System.out.print("Enter second number: ");
		number2 = input.nextInt();
		
		// Calculating the quotient and remainder
		int quotient = number1 / number2;
		int remainder = number1 % number2;
		
		// Printing the result
		System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder + " of two number " + number1 + " and " + number2);
		
		input.close();
	}
}
