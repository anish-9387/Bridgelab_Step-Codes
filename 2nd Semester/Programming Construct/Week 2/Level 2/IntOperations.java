import java.util.*;
// Class creation
class IntOperations{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating three variables
		int a, b, c;
		
		// Taking input from user
		System.out.print("Enter three numbers: ");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		
		// Calculating and printing the integer operations
		int result1 = a + b * c;	
		int result2 = a * b + c;	
		int result3 = c + a / b;	
		int result4 = a % b + c;
		
		// Printing the results
		System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + " and " + result4);
		
		input.close();
	}
}
