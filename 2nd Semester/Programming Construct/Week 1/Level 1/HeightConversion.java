import java.util.*;

// Class creation
class HeightConversion{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Taking height from the user
		double height;
		System.out.println("Enter your height: ");
		height = input.nextDouble();
		
		// Converting height in cm to inches
		double heightInInches = height / 2.54;
		
		// Calculating height in feet and inches
		int feet = (int)heightInInches / 12;
		
		int inches = (int)heightInInches % 12;
		
		// Displaying the result
		System.out.println("Your Height in cm is " + height + " while in feet is " + feet + " and inches is " + inches);
	}
}
