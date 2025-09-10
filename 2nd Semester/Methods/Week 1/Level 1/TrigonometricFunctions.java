import java.util.*;

// Class creation
class TrigonometricFunctions{
	// Method to calculate the trigonometric functions
	public static double[] calculateTrigonometricFunctions(double angle){
		double angleInRadians = Math.toRadians(angle);
		double sine = Math.sin(angleInRadians);
		double cosine = Math.cos(angleInRadians);
		double tangent = Math.tan(angleInRadians);
		
		return new double[] {sine,cosine,tangent};
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for angle
		System.out.print("Enter the angle (in degrees): ");
		double angle = input.nextDouble();
		
		// Printing the result
		double[] result = calculateTrigonometricFunctions(angle);
		System.out.println("Sine of angle: " + result[0] + ", cosine of angle: " + result[1] + " and tangent of angle: " + result[2]);
		
		input.close();
	}
}
