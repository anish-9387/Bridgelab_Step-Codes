import java.util.*;

// Class creation
class CountdownWhile{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the varaible for counter
		int counter;
		
		// Taking the value of counter
		System.out.print("Enter the counter: ");
		counter = input.nextInt();
		
		// Printing the count down
		while(counter >= 1){
			System.out.print(counter + " ");
			counter--;
		}
		
		input.close();
	}
}
