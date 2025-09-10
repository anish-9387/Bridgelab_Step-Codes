import java.util.*;

// Class creation
class FizzBuzz{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable number and string array
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		String[] array = new String[number+1];
		
		// Taking the array elements
		for(int i=0; i<=number; i++){
			if(i % 3 == 0 && i % 5 != 0){
				array[i] = "Fizz";
			}
			else if(i % 5 == 0 && i % 3 != 0){
				array[i] = "Buzz";
			}
			else if(i % 15 == 0){
				array[i] = "FizzBuzz";
			}
			else{
				array[i] = Integer.toString(i);
			}
		}
		
		// Displaying the results
		System.out.print("The array is: ");
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		
		input.close();
	}
}
