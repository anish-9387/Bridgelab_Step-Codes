import java.util.*;

// Class creation
class PowerOfNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for number, power and result
		int num, power, result = 1;
		
		// Taking the input from the user
		System.out.print("Enter a number: ");
		num = input.nextInt();
		System.out.print("Enter its power: ");
		power = input.nextInt();
		
		// Calculating and printing the power of number
		for(int i=1; i<=power; i++){
			result *= num;
		}
		
		System.out.println("Power of " + num + " raised to power " + power + " is: " + result);
	
		input.close();
	}
}
