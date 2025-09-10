import java.util.*;

// Class creation
class MultiplicationTable{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation and taking of integer input
		int number;
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Creation of the integer array
		int[] arr = new int[10];
		for(int i=1; i<=10; i++){
			arr[i-1] = (number * i);
		}
		
		// Printing the result
		System.out.println("The multiplication table of " + number + " is: ");
		for(int i=0; i<10; i++){
			System.out.println(number + " * " + (i+1) + " = " + arr[i]);
		}
		
		input.close();
	}
}
