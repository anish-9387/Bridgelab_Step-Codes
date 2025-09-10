import java.util.*;

// Class creation
class FindingBMI{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of varibles for weight and height
		double weight, height;
		
		// Taking the inputs from the user
		System.out.print("Enter your weight (in kg): ");
		weight = input.nextDouble();
		System.out.print("Enter your height (in cm): ");
		height = input.nextDouble();
		
		// Calculating BMI and printing the result
		double heightInM = height / 100;		
		double BMI = weight / (heightInM * heightInM);		
		System.out.println("Your BMI is: " + BMI);
		
		if(BMI <= 18.4){
			System.out.println("You are underweight");
		}
		else if(BMI >= 18.5 && BMI <= 24.9){
			System.out.println("You are normal");
		}
		else if(BMI >= 25 && BMI <= 39.9){
			System.out.println("You are overweight");
		}
		else{
			System.out.println("You are obese");
		}
		
		input.close();
	}
}
	