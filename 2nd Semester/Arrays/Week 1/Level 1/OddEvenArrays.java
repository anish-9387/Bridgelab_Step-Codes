import java.util.*;

// Class creation
class OddEvenArrays{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable number
		int number;
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		// Creation of arrays for odd and even numbers
		if(number >= 1){
			int[] odd = new int[number/2 + 1];
			int[] even = new int[number/2 + 1];
			
			int idxOdd = 0, idxEven = 0;
			for(int i=1; i<=number; i++){
				if(i % 2 == 0){
					even[idxEven] = i;
					idxEven++;
				}
				else{
					odd[idxOdd] = i;
					idxOdd++;
				}
			}
			
			// Printing the odd and even arrays
			System.out.print("Array of odd number: ");
			for(int i=0; i<number/2; i++){
				System.out.print(odd[i] + " ");
			}
			
			System.out.print("\nArray of even number: ");
			for(int i=0; i<number/2; i++){
				System.out.print(even[i] + " ");
			}
			
			input.close();
		}
		else{
			System.err.println("Error!! Enter a natural number");
			System.exit(1);
		}
	}
}
