import java.util.*;

// Class creation
public class UnitConverter{
	// Method to convert kilometers to miles
	public static double convertKmToMiles(double km){
		double km2miles = 0.621371;
		return km * km2miles;
	}
	
	// Method to convert miles to kilometers
	public static double convertMilesToKm(double miles){
		double miles2km = 1.60934;
		return miles * miles2km;
	}
	
	// Method to convert meters to feet
	public static double convertMetersToFeet(double meters){
		double meters2feet = 3.28084;
		return meters * meters2feet;
	}
	
	// Method to convert feet to meters
	public static double convertFeetToMeters(double feet){
		double feet2meters = 0.3048;
		return feet * feet2meters;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		UnitConverter uc = new UnitConverter();
		
		System.out.print("Enter distance (in kms): ");
		double km = input.nextDouble();
		System.out.print("Enter distance (in miles): ");
		double miles = input.nextDouble();
		System.out.print("Enter distance (in meters): ");
		double meters = input.nextDouble();
		System.out.print("Enter distance (in feet): ");
		double feet = input.nextDouble();
		
		// Printing the converted result
		double kmsToMiles = uc.convertKmToMiles(km);
		double milesToKms = uc.convertMilesToKm(miles);
		double metersToFeet = uc.convertMetersToFeet(meters);
		double feetToMeters = uc.convertFeetToMeters(feet);
		
		System.out.println(km + " kms --> " + kmsToMiles + " miles");
		System.out.println(miles + " miles --> " + milesToKms + " kms");
		System.out.println(meters + " meters --> " + metersToFeet + " feet");
		System.out.println(feet + " feet --> " + feetToMeters + " meters");
		
		input.close();
	}
}
