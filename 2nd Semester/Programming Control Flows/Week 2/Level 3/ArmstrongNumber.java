import java.util.*;

// Class creation
class ArmstrongNumber{
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of variables for number and sum
		int number, sum = 0;
		
		// Taking the number from the user
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Checking and printing armstrong number
		int originalNumber = number;
		
		while(originalNumber != 0){
			int lastDigit;
			lastDigit = originalNumber % 10;
			sum += lastDigit * lastDigit * lastDigit;
			originalNumber /= 10;
		}
		
		if(sum == number){
			System.out.println(number + " is an Armstrong number");
		}
		else{
			System.out.println(number + " is not an Armstrong number");
		}
		input.close();
	}
}
