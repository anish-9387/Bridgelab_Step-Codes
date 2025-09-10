import java.util.*;

// Class creation
class AbundantNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of variables for the number and sum
		int number, sum=0;
		
		// Taking the input from the user
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Checking Abundant number and printing the result
		for(int i=1; i<number; i++){
			if(number % i == 0){
				sum += i;
			}
		}
		
		if(sum > number){
			System.out.println("Abundant Number");
		}
		else{
			System.out.println("Not an Abundant Number");
		}
		
		input.close();
	}
}
