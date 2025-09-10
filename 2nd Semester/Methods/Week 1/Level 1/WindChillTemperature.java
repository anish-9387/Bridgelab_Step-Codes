import java.util.*;

// Class creation
class WindChillTemperature{
	// Method to calculate the wind chill temperature
	public static double calculateWindChill(double temperature, double windSpeed){
		double windChill = 35.74 + 0.6215*temperature + (0.4275*temperature - 35.75) * Math.pow(windSpeed, 0.16);
		return windChill;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for temperature and wind speed
		System.out.print("Enter the temperature: ");
		double temperature = input.nextDouble();
		System.out.print("Enter the wind speed: ");
		double windSpeed = input.nextDouble();
		
		// Printing the result
		double result = calculateWindChill(temperature,windSpeed);
		System.out.println("Wind chill temperature is: " + result);
		
		input.close();
	}
}
