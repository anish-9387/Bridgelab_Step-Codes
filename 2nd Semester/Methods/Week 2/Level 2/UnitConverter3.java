import java.util.*;

// Class creation
public class UnitConverter3{
	// Method to convert fahrenheit to celsius
	public static double convertFahrenheitToCelsius(double fahrenheit){
		double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
		return fahrenheit2celsius;
	}
	
	// Method to convert celsius to fahrenheit
	public static double convertCelsiusToFahrenheit(double celsius){
		double celsius2fahrenheit = (celsius * 9 / 5) + 32;
		return celsius2fahrenheit;
	}
	
	// Method to convert pounds to kilograms
	public static double convertPoundsToKilograms(double pounds){
		double pounds2kilograms = 0.453592;
		return pounds * pounds2kilograms;
	}
	
	// Method to convert kilograms to pounds
	public static double convertKilogramsToPounds(double kilograms){
		double kilograms2pounds = 2.20462; 
		return kilograms * kilograms2pounds;
	}
	
	// Method to convert gallons to litres
	public static double convertGallonsToLitres(double gallons){
		double gallons2liters = 3.78541; 
		return gallons * gallons2liters;
	}
	
	// Method to convert litres to gallons
	public static double convertLitresToGallons(double litres){
		double liters2gallons = 0.264172; 
		return litres * liters2gallons;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		UnitConverter3 uc = new UnitConverter3();
		
		System.out.print("Enter temperature (in fahrenheit): ");
		double fahrenheit = input.nextDouble();
		System.out.print("Enter temperature (in celsius): ");
		double celsius = input.nextDouble();
		System.out.print("Enter weight (in pounds): ");
		double pounds = input.nextDouble();
		System.out.print("Enter weight (in kgs): ");
		double kilograms = input.nextDouble();
		System.out.print("Enter quantity (in gallons): ");
		double gallons = input.nextDouble();
		System.out.print("Enter quantity (in litres): ");
		double litres = input.nextDouble();
		
		// Printing the converted result
		double fahrenheitToCelsius = uc.convertFahrenheitToCelsius(fahrenheit);
		double celsiusToFahrenheit = uc.convertCelsiusToFahrenheit(celsius);
		double poundsToKilograms = uc.convertPoundsToKilograms(pounds);
		double kilogramsToPounds = uc.convertKilogramsToPounds(kilograms);
		double gallonsToLitres = uc.convertGallonsToLitres(gallons);
		double litersToGallons = uc.convertLitresToGallons(litres);
		
		System.out.println(fahrenheit + " fahrenheit --> " + fahrenheitToCelsius + " celsius");
		System.out.println(celsius + " celsius --> " + celsiusToFahrenheit + " fahrenheit");
		System.out.println(pounds + " pounds --> " + poundsToKilograms + " kilograms");
		System.out.println(kilograms + " kilograms --> " + kilogramsToPounds + " pounds");
		System.out.println(gallons + " gallons --> " + gallonsToLitres + " liters");
		System.out.println(litres + " liters --> " + litersToGallons + " gallons");
		
		input.close();
	}
}
