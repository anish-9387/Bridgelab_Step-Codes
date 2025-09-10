import java.util.*;

// Class creation
class DivisibleByFive{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the varible for the number
		int num;
		
		// Taking the input from the user
		System.out.print("Enter the number: ");
		num = input.nextInt();
		
		// Checking if number is divisible by five or not
		System.out.println("Is the number " + num + " divisible by 5?: " + (num % 5 == 0));
		
		input.close();
	}
}
