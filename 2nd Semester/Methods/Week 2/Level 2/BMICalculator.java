import java.util.*;

// Class creation
public class BMICalculator{
	// Method to calculate the BMI of each person
	public double[][] calculateBMI(double[][] arr){
		for(int i=0; i<10; i++){
			double heightInMeters = arr[i][1] / 100;
			arr[i][2] = arr[i][0] / (heightInMeters * heightInMeters);
		}
		return arr;
	}
	
	// Method to find the BMI status of each person
	public String[] findBMIStatus(double[][] arr){
		String[] bmiStatus = new String[10];
		for(int i=0; i<10; i++){
			if(arr[i][2] <= 18.4)  bmiStatus[i] = "Underweight";
			else if(arr[i][2] >= 18.5 && arr[i][2] <= 24.9)  bmiStatus[i] = "Normal";
			else if(arr[i][2] >= 25.0 && arr[i][2] <= 39.9)  bmiStatus[i] = "Overweight";
			else  bmiStatus[i] = "Obese";
		}
		return bmiStatus;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		BMICalculator bc = new BMICalculator();
		
		// Creating array, taking input from the user and printing the result
		double[][] arr = new double[10][3];
		for(int i=0; i<10; i++){
			System.out.print("Enter weight (in kg) of person " + (i+1) + ": ");
			arr[i][0] = input.nextDouble();
			System.out.print("Enter height (in cm) of person " + (i+1) + ": ");
			arr[i][1] = input.nextDouble();
		}
		
		arr = bc.calculateBMI(arr);
		
		String[] bmiStatus = bc.findBMIStatus(arr);
		
		for(int i=0; i<10; i++){
			System.out.println("BMI Status of person " + (i + 1) + ": ");
			System.out.println("Weight: " + arr[i][0] + " kg");
			System.out.println("Height: " + arr[i][1] + " cm");
			System.out.println("BMI: " + arr[i][2]);
			System.out.println("Status: " + bmiStatus[i]);
		}		
		input.close();
	}
}
