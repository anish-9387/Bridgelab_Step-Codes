import java.util.*;

// Class creation
public class UnitConverter2{
	// Method to convert yards to feet
	public static double convertYardsToFeet(double yards){
		double yards2feet = 3;
		return yards * yards2feet;
	}
	
	// Method to convert feet to yards
	public static double convertFeetToYards(double feet){
		double feet2yards = 0.333333;
		return feet * feet2yards;
	}
	
	// Method to convert meters to inches
	public static double convertMetersToInches(double meters){
		double meters2inches = 39.3701;
		return meters * meters2inches;
	}
	
	// Method to convert inches to meters
	public static double convertInchesToMeters(double inches){
		double inches2meters = 0.0254;
		return inches * inches2meters;
	}
	
	// Method to convert inches to centimeters
	public static double convertInchesToCentimeters(double inches){
		double inches2cm = 2.54;
		return inches * inches2cm;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		UnitConverter2 uc = new UnitConverter2();
		
		System.out.print("Enter distance (in yards): ");
		double yards = input.nextDouble();
		System.out.print("Enter distance (in feet): ");
		double feet = input.nextDouble();
		System.out.print("Enter distance (in meters): ");
		double meters = input.nextDouble();
		System.out.print("Enter distance (in inches): ");
		double inches = input.nextDouble();
		
		// Printing the converted result
		double yardsToFeet = uc.convertYardsToFeet(yards);
		double feetToYards = uc.convertFeetToYards(feet);
		double metersToInches = uc.convertMetersToInches(meters);
		double inchesToMeters = uc.convertInchesToMeters(inches);
		double inchesToCentimeters = uc.convertInchesToCentimeters(inches);
		
		System.out.println(yards + " yards --> " + yardsToFeet + " feet");
		System.out.println(feet + " feet --> " + feetToYards + " yards");
		System.out.println(meters + " meters --> " + metersToInches + " inches");
		System.out.println(inches + " inches --> " + inchesToMeters + " meters");
		System.out.println(inches + " inches --> " + inchesToCentimeters + " centimeters");
		
		input.close();
	}
}
