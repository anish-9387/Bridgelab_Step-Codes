import java.util.*;
// Class creation
class FizzBuzzWhile{
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creating the variable for number
		int num, i = 0;
		
		// Taking the input from the user
		System.out.print("Enter the number: ");
		num = input.nextInt();
		
		// Printing the results
		if(num > 0){
			while(i <= num){
				if(i % 3 == 0 && i % 5 != 0){
					System.out.println(i + " --> Fizz");
				}
				else if(i % 5 == 0 && i % 3 != 0){
					System.out.println(i + " --> Buzz");
				}
				else if(i % 3 == 0 && i % 5 == 0){
					System.out.println(i + " --> FizzBuzz");
				}
				i++;
			}
		}
		else{
			System.out.println("Invalid!!!\nEnter a positive integer");
		}
	}
}
