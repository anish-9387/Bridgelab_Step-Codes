import java.util.*;

// Class creation
public class FactorsNumber{
	// Method to create an array of factors
	public int[] numberFactors(int n){
		int count = 0;
		for(int i=1; i<=n; i++){
			if(n % i == 0)  count++;
		}
		int[] arr = new int[count];
		int index = 0;
		for(int i=1; i<=n; i++){
			if(n % i == 0){
				arr[index] = i;
				index++;
			}
		}
		return arr;
	}
	
	// Method to calculate the sum of factors
	public int sumOfFactors(int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}
	
	// Method to calculate the sum of squares of factors
	public int sumOfSquares(int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += (int)Math.pow(arr[i],2);
		}
		return sum;
	}
	
	// Method to calculate the product of factors
	public long productOfFactors(int[] arr){
		long product = 1;
		for(int i=0; i<arr.length; i++){
			product *= arr[i];
		}
		return product;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Instantiation of the object
		FactorsNumber fn = new FactorsNumber();
	
		System.out.print("Enter number: ");
		int number = input.nextInt();
	
		int[] factorArray = fn.numberFactors(number);
		
		int sum = fn.sumOfFactors(factorArray);		
		int sumSquares = fn.sumOfSquares(factorArray);		
		long productFactors = fn.productOfFactors(factorArray);
		
		// Printing the result
		System.out.println("Number: " + number);
		System.out.print("Factors array: ");
		for(int i=0; i<factorArray.length; i++){
			System.out.print(factorArray[i] + " ");
		}
		System.out.println("\nSum of factors: " + sum);
		System.out.println("Sum of squares of factors: " + sumSquares);
		System.out.println("Product of factors: " + productFactors);
		
		input.close();
	}
}
