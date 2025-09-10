import java.util.*;

// Class creation
class NumberOfRounds{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for the sides of the triangle
		int side1, side2, side3;
		
		// Taking the inputs from the user
		System.out.print("Enter the side 1 in meters: ");
		side1 = input.nextInt();
		System.out.print("Enter the side 2 in meters: ");
		side2 = input.nextInt();
		System.out.print("Enter the side 3 in meters: ");
		side3 = input.nextInt();
		
		// Calculating the number of rounds
		int perimeter = side1 + side2 + side3;
		int numberOfRounds = 5000 / perimeter;
		
		// Printing the result 
		System.out.println("The total number of rounds the athlete will run is " + numberOfRounds + " to complete 5 km");
		
		input.close();
	}
}
		