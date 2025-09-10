import java.util.*;

// Class creation
class SumOfNaturalNumberBy2Methods{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for the number and sum
		int num, sumUsingFormula = 0, sumUsingWhileLoop = 0;
		
		// Taking the number as input
		System.out.print("Enter the number till which sum is required: ");
		num = input.nextInt();
		
		// Calculating the sum using formula and while loop
		if(num >= 1){
			sumUsingFormula = (num * (num + 1)) / 2;
			
			while(num >= 1){
				sumUsingWhileLoop += num;
				num--;
			}
			
			System.out.println("Sum using formula: " + sumUsingFormula);
			System.out.println("Sum using while loop: " + sumUsingWhileLoop);
		}
		else{
			System.out.println("Enter natural number!!");
		}
		
		input.close();
	}
}
