import java.util.*;
// Class creation
class Calculator{
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of two float variables
		double number1;
		double number2;
		
		// Taking the input from the user
		System.out.print("Enter first number: ");
		number1 = input.nextDouble();		
		System.out.print("Enter second number: ");
		number2 = input.nextDouble();
		
		// Calculating arithmetic operations
		double addition = number1 + number2;		
		double subtraction = number1 - number2;		
		double multiplication = number1 * number2;		
		double division = number1 / number2;
		
		System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + ", " + subtraction + ", " + multiplication + " and " + division);
		
		// Closing the scanner
		input.close();
	}
}
