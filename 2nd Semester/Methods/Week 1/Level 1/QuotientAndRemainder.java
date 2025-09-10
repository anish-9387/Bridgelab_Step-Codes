import java.util.*;

// Class creation
class QuotientAndRemainder{
	// Method to find quotient and remainder
	public static int[] findRemainderAndQuotient(int number, int divisor){
		int remainder = number % divisor;
		int quotient = number / divisor;
		
		return new int[] {quotient,remainder};
	}
	
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for number and divisor
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		System.out.print("Enter the divisor: ");
		int divisor = input.nextInt();
			
		// Printing the quotient and remainder
		int[] result = findRemainderAndQuotient(number,divisor);
		System.out.println("Quotient: " + result[0] + " and Remainder: " + result[1]);
		
		input.close();
	}
}
