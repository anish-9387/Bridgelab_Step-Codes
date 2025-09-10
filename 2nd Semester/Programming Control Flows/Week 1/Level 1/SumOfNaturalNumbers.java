import java.util.*;

// Class creation
class SumOfNaturalNumbers{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable
		int num;
		
		// Taking the input
		System.out.print("Enter the number till which sum is required: ");
		num = input.nextInt();
		
		// Calculating the sum of natural numbers
		if(num >= 0){
			int sum = num * (num + 1) / 2;
			System.out.println("The sum of " + num + " natural numbers is " + sum);
		}
		else{
			System.out.println("The number " + num + " is not a natural number");
		}
		
		input.close();
	}
}
