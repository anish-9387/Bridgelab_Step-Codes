import java.util.*;

// Class creation
class TemperatureConversion{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of celsius variable
		double celsius;
		
		// Taking the input from the user
		System.out.print("Enter the temperature in celsius: ");
		celsius = input.nextDouble();
		
		// Converting celsius to farenheit
		double farenheitResult = (celsius * 9/5) + 32;
		
		// Printing the result
		System.out.println("The " + celsius + " celsius is " + farenheitResult + " farenheit");
		
		input.close();
	}
}
