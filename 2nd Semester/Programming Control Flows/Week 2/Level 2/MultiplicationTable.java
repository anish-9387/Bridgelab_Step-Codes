import java.util.*;

// Class creation
class MutiplicationTable{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of variable for the number
		int number;
		
		// Taking the input from the user
		System.out.print("Enter the number: ");
		number = input.nextInt();
		
		// Printing the table from 6 to 9
		for(int i=6; i<=9; i++){
			System.out.println(number + " * " + i + " = " + number * i);
		}
		
		input.close();
	}
}
