import java.util.*;

// Class creation
class DistanceConverter{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variable for distance in feet
		double distanceInFeet;
		
		// Taking the distance from user
		System.out.print("Enter the distance in feet: ");
		distanceInFeet = input.nextDouble();
		
		// Calculating the distance in yards and miles
		double distanceInYards, distanceInMiles;
		
		distanceInYards = distanceInFeet / 3;
		
		distanceInMiles = distanceInYards / 1760;
		
		// Printing the result
		System.out.println("Your Distance in yards is " + distanceInYards + " while in miles is " + distanceInMiles);
		
		input.close();
	}
}
