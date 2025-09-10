import java.util.*;

// Class creation
class SumUsingWhile{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for number and total
		double num, total = 0.0;
		
		// Calculating the sum until user enter 0
		System.out.print("Enter a number: ");
		num = input.nextDouble();
		
		while(num != 0){
			total += num;
			System.out.print("Enter another number: ");
			num = input.nextDouble();
		}
		
		// Printing the sum
		System.out.println("The total sum is: " + total);
		
		input.close();
	}
}
			