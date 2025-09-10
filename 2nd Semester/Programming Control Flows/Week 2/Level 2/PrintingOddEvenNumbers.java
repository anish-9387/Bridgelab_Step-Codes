import java.util.*;

// Class creation
class PrintingOddEvenNumbers{
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creating the variable for number
		int number;
		
		// Taking the input from the user
		System.out.print("Enter the number: ");
		number = input.nextInt();
		
		// Printing whether the number is even or odd
		if(number >= 1){
			for(int i=1; i<=number; i++){
				if(i % 2 == 0){
					System.out.println("The number " + i + " is even");
				}
				else{
					System.out.println("The number " + i + " is odd");
				}
			}
		}
		else{
			System.out.println("Please enter a valid natural number");
		}
		
		input.close();
	}
}
