import java.util.Scanner;

public class BMICalculator{
    public static String[] calculateBMI(double weight, double heightCm){
        double heightM=heightCm/100.0;
        double bmi=weight/(heightM*heightM);

        String status;
        if(bmi<=18.4){
            status="Underweight";
        }
        else if(bmi<=24.9){
            status="Normal";
        }
        else if(bmi<=39.9){
            status="Overweight";
        }
        else{
            status="Obese";
        }
        return new String[]{String.format("%.1f",bmi), status};
    }

    public static String[][] processPersons(double[][] hw){
        int n=hw.length;
        String[][] result=new String[n][4];

        for(int i=0; i<n; i++){
            double weight=hw[i][0];
            double height=hw[i][1];

            String[] bmiResult=calculateBMI(weight,height);

            result[i][0]=String.format("%.1f", height);
            result[i][1]=String.format("%.1f", weight);
            result[i][2]=bmiResult[0];
            result[i][3]=bmiResult[1];
        }
        return result;
    }

    public static void displayTable(String[][] arr){
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------");

        for(int i=0; i<arr.length; i++){
            System.out.printf("%-10s %-10s %-10s %-15s%n", arr[i][0], arr[i][1], arr[i][2], arr[i][3]);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        double[][] hw=new double[10][2];

        for(int i=0; i<10; i++){
            System.out.println("Enter details for Person "+(i+1)+":");
            System.out.print("Weight (kg): ");
            hw[i][0]=input.nextDouble();
            System.out.print("Height (cm): ");
            hw[i][1]=input.nextDouble();
        }

        String[][] result=processPersons(hw);

        System.out.println("\n====== BMI REPORT ======");
        displayTable(result);
        input.close();
    }
}
