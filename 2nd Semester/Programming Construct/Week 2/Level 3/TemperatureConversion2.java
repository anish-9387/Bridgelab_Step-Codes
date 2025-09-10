import java.util.*;

// Class creation
class TemperatureConversion2{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of farenheit variable
		double fahrenheit;
		
		// Taking the input from the user
		System.out.print("Enter the temperature in fahrenheit: ");
		fahrenheit = input.nextDouble();
		
		// Converting celsius to farenheit
		double celsiusResult = (fahrenheit - 32) * 5 / 9;
		
		// Printing the result
		System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius");
		
		input.close();
	}
}
