import java.util.*;

// Class creation
class FactorialUsingFor{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variable for number
		int num, factorial = 1;
		
		// Taking the number as input
		System.out.print("Enter the number whose factorial is to be calculated: ");
		num = input.nextInt();
		
		// Calculating the factorial using for loop
		if(num >= 0){
			for(int i=1; i<=num; i++){
				factorial *= i;
			}
			
			System.out.println("The factorial of the entered number is: " + factorial);
		}
		else{
			System.out.println("Please enter positive integer!!");
		}		
		input.close();
	}
}
