import java.util.*;

// Class creation
class SideFromParameter{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variable for parameter
		double parameterOfSquare;
		
		// Taking the parameter from the user
		System.out.print("Enter the parameter of square: ");
		parameterOfSquare = input.nextDouble();
		
		// Calculating the side of square from perimeter
		double side = parameterOfSquare / 4;
		
		// Printing the result
		System.out.println("The length of the side is " + side + " whose perimeter is " + parameterOfSquare);
		
		input.close();
	}
}
