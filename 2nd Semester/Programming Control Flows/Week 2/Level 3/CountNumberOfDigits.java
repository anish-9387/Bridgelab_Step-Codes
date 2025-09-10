import java.util.*;

// Class creation
class CountNumberOfDigits{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of variables for the number and count
		int number, count = 0;
		
		// Taking the number from the user
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Counting the number of digits and printing it
		while(number != 0){
			count++;
			number /= 10;
		}
		
		System.out.println("Count of digits: " + count);
		
		input.close();
	}
}
