import java.util.*;

// Class creation
class GreatestFactor{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating a variable for number
		int num, greatestFactor = 1;
		
		// Taking the input from the user
		System.out.print("Enter a number: ");
		num = input.nextInt();
		
		// Finding and printing the greatest factor
		for(int i=num-1; i>=1; i--){
			if(num % i == 0){
				greatestFactor = i;
				break;
			}
		}
		System.out.println("Greatest factor of the number: " + greatestFactor);
		
		input.close();
	}
}
