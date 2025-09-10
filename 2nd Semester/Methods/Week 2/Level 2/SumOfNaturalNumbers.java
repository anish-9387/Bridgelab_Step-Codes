import java.util.*;

// Class creation
public class SumOfNaturalNumbers{
	// Recursive method to calculate the sum of natural numbers
	public int recursiveSumCalculation(int n){
		if(n == 1)  return 1;
		return (n + recursiveSumCalculation(n-1));	    
	}
	
	// Method to calculate the sum using formula
	public int formulaSumCalculation(int n){
		int sum = n * (n + 1) / 2;
		return sum;
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		SumOfNaturalNumbers sum = new SumOfNaturalNumbers();		
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		
		// Displaying the results
		System.out.println("Sum of first " + number + " natural numbers using recursive function is: " + sum.recursiveSumCalculation(number));
		System.out.println("Sum of first " + number + " natural numbers using formula is: " + sum.formulaSumCalculation(number));
		
		input.close();
	}
}
