import java.util.*;

// Class creation
class FactorialUsingWhile{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variable for number
		int num, factorial = 1;
		
		// Taking the number as input
		System.out.print("Enter the number whose factorial is to be calculated: ");
		num = input.nextInt();
		
		// Calculating the factorial using while loop
		if(num >= 0){
			while(num >= 1){
				factorial *= num;
				num--;
			}
			
			System.out.println("The factorial of the entered number is: " + factorial);
		}
		else{
			System.out.println("Please enter positive integer!!");
		}		
		input.close();
	}
}
