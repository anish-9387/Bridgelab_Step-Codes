import java.util.*;

// Class creation
class WeightConversion{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for the weight in pounds
		double weightInPounds;
		
		// Taking input from the user
		System.out.print("Enter the weight in pounds: ");
		weightInPounds = input.nextDouble();
		
		// Converting the weight from pounds to kgs
		double weightInKgs = weightInPounds * 2.2;
		
		// Printing the result
		System.out.println("The weight of the person in pound is " + weightInPounds + " and in kg is " + weightInKgs);
		
		input.close();
	}
}
