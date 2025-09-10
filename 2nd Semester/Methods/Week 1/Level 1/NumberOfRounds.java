import java.util.*;

// Class creation
class NumberOfRounds{	
	// Method to calcualte number of rounds the athelete complete
	public static int calculateNoOfRounds(int side1, int side2, int side3){
		return (5000 / (side1 + side2 + side3));
	}
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for sides of triangle
		System.out.print("Enter the side 1: ");
		int side1 = input.nextInt();
		System.out.print("Enter the side 2: ");
		int side2 = input.nextInt();
		System.out.print("Enter the side 3: ");
		int side3 = input.nextInt();
		
		// Calculating number of rounds and printing it
		int rounds = calculateNoOfRounds(side1,side2,side3);
		System.out.println("Number of rounds the athelete completes is: " + rounds);
		
		input.close();
	}
}
