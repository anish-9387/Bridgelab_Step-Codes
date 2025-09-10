import java.util.*;

// Class creation
class IsPrime{
	public static void main(String[] args){		
	
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for number and isPrime
		int number;
		boolean isPrime = true;
		
		// Taking the input from the user
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Checking whether the number is prime or not
		if(number > 1){
			for(int i=2; i<number; i++){
				if(number % i == 0){
					isPrime = false;
					break;
				}
			}
			System.out.println("Is " + number + " prime?: " + isPrime);
		}
		else{
			System.out.println("Invalid!! Enter number >= 1");
		}
		input.close();
	}
}
