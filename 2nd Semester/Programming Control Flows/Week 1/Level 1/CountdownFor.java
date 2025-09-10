import java.util.*;

// Class creation
class CountdownFor{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the varaible for counter
		int counter;
		
		// Taking the value of counter
		System.out.print("Enter the counter: ");
		counter = input.nextInt();
		
		// Printing the count down
		for(int i=counter; i>=1 ; i--){
			System.out.print(i + " ");
		}
		
		input.close();
	}
}
