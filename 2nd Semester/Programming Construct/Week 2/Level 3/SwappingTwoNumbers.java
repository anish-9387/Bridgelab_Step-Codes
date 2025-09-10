import java.util.*;

// Class creation
class SwappingTwoNumbers{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for the two numbers
		int number1, number2;
		
		// Taking the inputs from the user
		System.out.print("Enter first number: ");
		number1 = input.nextInt();
		
		System.out.print("Enter second number: ");
		number2 = input.nextInt();
		
		// Swapping algorithm
		int temp = number1;
		number1 = number2;
		number2 = temp;
		
		// Printing the result
		System.out.println("The swapped numbers are " + number1 + " and " + number2);
		
		input.close();
	}
}
