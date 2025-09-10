import java.util.*;

// Class creation
class SumOfNaturalNumbers{
	// Method to find sum of n natural numbers
	public static int sum(int n){
		if(n < 0)  return -1;
		else{
			int sum = 0;
			for(int i=1; i<=n; i++){
				sum += i;
			}
			return sum;
		}
	}
	
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for number
		System.out.print("Enter the number: ");
		int num = input.nextInt();
		
		// Printing the sum of natural numbers
		int result = sum(num);
		System.out.println("Sum of first " + num + " natural numbers is: " + result);
		
		input.close();
	}
}
