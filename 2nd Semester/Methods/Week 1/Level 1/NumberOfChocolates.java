import java.util.*;

// Class creation
class NumberOfChocolates{
	// Method to find number of chocolates each children will get
	public static int[] findRemainderAndQuotient(int number, int divisor){
		int remainder = number % divisor;
		int quotient = number / divisor;
		
		return new int[] {quotient,remainder};
	}
	
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for number of children and chocolates
		System.out.print("Enter the number of children: ");
		int numberOfChildren = input.nextInt();
		System.out.print("Enter the number of chocolates: ");
		int numberOfchocolates = input.nextInt();
			
		// Printing the result
		int[] result = findRemainderAndQuotient(numberOfchocolates,numberOfChildren);
		System.out.println("Each children will get " + result[0] + " chocolates and Remaining chocolates are " + result[1]);
		
		input.close();
	}
}
