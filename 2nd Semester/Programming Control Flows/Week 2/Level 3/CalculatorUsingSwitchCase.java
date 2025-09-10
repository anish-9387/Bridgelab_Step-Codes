import java.util.*;

// Class creation
class CalculatorUsingSwitchCase{
	public static void main(String[] args){	
	
		Scanner input = new Scanner(System.in);
		
		// Creation of variables for first, second and operator
		double first, second;
		String op;
		
		// Taking the input from the user
		System.out.print("Enter the first number and second number: ");
		first = input.nextDouble();
		second = input.nextDouble();
		System.out.print("Enter the operator: ");
		op = input.next();
		
		// Calculator using switch case
		switch(op){
			case "+":
				System.out.println("Addition of the two numbers is: " + (first+second));
				break;
			case "-":
				System.out.println("Subtraction of the two numbers is: " + (first-second));
				break;
			case "*":
				System.out.println("Multiplication of the two numbers is: " + (first*second));
				break;
			case "/":
				System.out.println("Division of the two numbers is: " + (first/second));
				break;
			default:
				System.out.println("Invalid Operator");
		}
		
		input.close();
	}
}
