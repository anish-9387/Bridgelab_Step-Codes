import java.util.*;

// Class creation
class SumUsingInfiniteWhile{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for the number and total
		double num, total = 0.0;
		
		// Calculating the sum until the user enters 0 or -ve number
		System.out.print("Enter a number: ");
		num = input.nextDouble();
		
		while(true){
			if(num <= 0){
				break;
			}
			else{
				total += num;
				System.out.print("Enter another number: ");
				num = input.nextDouble();
			}
		}
		System.out.println("The total sum is: " + total);
		
		input.close();
	}
}
