import java.util.*;

// Class creation
class KilometersToMilesUsingInput{
	public static void main(String[] args){
		
		// Creating a variable for storing km
		double km;
		
		// Creating scanner object
		Scanner input = new Scanner(System.in);
		
		// Taking input from user
		km = input.nextInt();
		
		// Calculating the distance in miles
		double miles = km * 1.6;
		
		// Displaying result
		System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
	}
}
