import java.util.*;

// Class creation
class LargestOfThree{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for the three numbers
		int num1, num2, num3;
		
		// Taking the input from the user
		System.out.print("Enter the three numbers: ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		num3 = input.nextInt();
		
		// Checking if numbers are largest or not
		System.out.println("Is the first number the largest?: " + ((num1 > num2) ? (num1 > num3) : false));
		System.out.println("Is the second number the largest?: " + ((num2 > num1) ? (num2 > num3) : false));
		System.out.println("Is the third number the largest?: " + ((num3 > num1) ? (num3 > num2) : false));
		
		input.close();
	}
}
