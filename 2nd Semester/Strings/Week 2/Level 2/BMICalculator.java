import java.util.*;

// Class creation
public class BMICalculator{
    // Method to calculate BMI and status
    public String[][] calculateBMI(double[][] data){
        String[][] result = new String[10][4];
        
        for(int i=0; i<10; i++){
            double weight = data[i][0];
            double heightInCm = data[i][1];
            double heightInM = heightInCm / 100;
            double bmi = weight / (heightInM * heightInM);

            String status;
            if(bmi < 18.5){
                status = "Underweight";
            }
			else if(bmi < 24.9){
                status = "Normal weight";
            }
			else if(bmi < 29.9){
                status = "Overweight";
            }
			else{
                status = "Obese";
            }

            result[i][0] = String.format("%.2f",heightInCm);
            result[i][1] = String.format("%.2f",weight);
            result[i][2] = String.format("%.2f",bmi);
            result[i][3] = status;
        }        
        return result;
    }

    // Method to display the data
    public void displayData(String[][] data){
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Height(in cm)", "Weight(in kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------");
        
        for(int i=0; i<10; i++){
            System.out.printf("%-15s %-15s %-15s %-15s%n",data[i][0],data[i][1],data[i][2],data[i][3]);
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		BMICalculator obj = new BMICalculator();
		
        double[][] data = new double[10][2];

        // Taking input from the user
        for(int i=0; i<10; i++){
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Weight (in kg): ");
            data[i][0] = input.nextDouble();
            System.out.print("Height (in cm): ");
            data[i][1] = input.nextDouble();
        }

		// Displaying the result
        String[][] result = obj.calculateBMI(data);
        obj.displayData(result);
        
        input.close();
    }
}
