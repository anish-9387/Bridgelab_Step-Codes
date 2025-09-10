import java.util.*;

// Class creation
class NatureOfNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for the number
		int num;
		
		// Taking the input from the user
		System.out.print("Enter the number: ");
		num = input.nextInt();
		
		// Checking the nature of the number
		if(num > 0){
			System.out.println("Positive");
		}
		else if(num < 0){
			System.out.println("Negative");
		}
		else{
			System.out.println("The number is zero");
		}
		
		input.close();
	}
}
