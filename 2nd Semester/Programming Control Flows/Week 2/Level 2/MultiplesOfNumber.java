import java.util.*;

// Class creation
class MultiplesOfNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of a variable for number
		int num;
		
		// Taking the input from the user
		System.out.print("Enter a number: ");
		num = input.nextInt();
		
		// Printing the multiples of the number entered
		System.out.print("Multiples: ");
		for(int i=100; i>=1; i--){
			if(num % i == 0){
				System.out.print(i + " ");
				continue;
			}
		}
		
		input.close();
	}
}
