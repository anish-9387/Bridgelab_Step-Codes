import java.util.*;
// Class creation
class AreaOfTriangle{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for base and height
		double base, height;
		
		// Taking input from the user
		System.out.print("Enter the base (in cm) of triangle: ");
		base = input.nextDouble();
		System.out.print("Enter the height (in cm) of triangle: ");
		height = input.nextDouble();
		
		// Calculating the area of triangle in square cm
		double areaInSqCm = 0.5 * base * height;
		
		// Calculating the area of triangle in square inches
		double baseInInch = base / 2.54;
		double heightInInch = height / 2.54;
		double areaInInches = 0.5 * baseInInch * heightInInch;
		
		System.out.println("Area of triangle in square centimeters is " + areaInSqCm + " while in square inches is " + areaInInches);
		
		input.close();
	}
}
		