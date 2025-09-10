import java.util.*;
// Class creation
class FizzBuzz{
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creating the variable for number
		int num;
		
		// Taking the input from the user
		System.out.print("Enter the number: ");
		num = input.nextInt();
		
		// Printing the results
		if(num > 0){
			for(int i=0; i<=num; i++){
				if(i % 3 == 0 && i % 5 != 0){
					System.out.println(i + " --> Fizz");
				}
				else if(i % 5 == 0 && i % 3 != 0){
					System.out.println(i + " --> Buzz");
				}
				else if(i % 3 == 0 && i % 5 == 0){
					System.out.println(i + " --> FizzBuzz");
				}
			}
		}
		else{
			System.out.println("Invalid!!!\nEnter a positive integer");
		}		
		input.close();
	}
}
