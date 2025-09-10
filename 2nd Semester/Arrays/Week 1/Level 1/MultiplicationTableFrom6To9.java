import java.util.*;

// Class creation
class MultiplicationTableFrom6To9{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation and taking of integer input
		int number;
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Creation of the integer array
		int[] multiplicationResult = new int[10];
		for(int i=0; i<4; i++){
			multiplicationResult[i] = (number * (i+6));
		}
		
		// Printing the result
		System.out.println("The multiplication table of " + number + " from 6 to 9 is: ");
		for(int i=0; i<4; i++){
			System.out.println(number + " * " + (i+6) + " = " + multiplicationResult[i]);
		}
		
		input.close();
	}
}
