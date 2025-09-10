import java.util.*;

// Class creation
class FactorsOfNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating a variable for number
		int num;
		
		// Taking the input from the user
		System.out.print("Enter a number: ");
		num = input.nextInt();
		
		// Finding and printing the factors of number
		System.out.print("Factors: ");
		for(int i=1; i<=num; i++){
			if(num % i == 0){
				System.out.print(i + " ");
			}
		}
		
		input.close();
	}
}
