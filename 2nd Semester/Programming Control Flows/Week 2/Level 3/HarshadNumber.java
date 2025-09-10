import java.util.*; 

// Class creation
class HarshadNumber{
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of variables for the number and sum
		int number, sum = 0;
		
		// Taking the number from the user
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Checking and printing the harshad number
		int originalNumber = number;
		while(originalNumber != 0){
			int lastDigit = originalNumber % 10;
			sum += lastDigit;
			originalNumber /= 10;
		}
		
		if(number % sum == 0){
			System.out.println("Harshad number");
		}
		else{
			System.out.println("Not a Harshad number");
		}
		
		input.close();
	}
}
