import java.util.*;

// Class creation
class FirstNumberSmallest{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for three numbers
		int num1, num2, num3;
		
		// Taking the input from the user
		System.out.print("Enter the three numbers: ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		num3 = input.nextInt();
		
		// Checking if the first number is smallest or not
		System.out.println("Is the first number the smallest?: " + (num1 < num2 ? (num1 < num3) : false));
		
		input.close();
	}
}
