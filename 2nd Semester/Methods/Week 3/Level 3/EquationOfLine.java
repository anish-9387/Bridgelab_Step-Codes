import java.util.*;

// Class creation
public class EquationOfLine{
    // Method to find Euclidean distance between two points
    public double calculateDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    // Method to find the equation of the line
    public double[] findLineEquation(double x1, double y1, double x2, double y2){
        double slope, yIntercept;
        if(x2 - x1 == 0){
            throw new ArithmeticException("Slope is undefined for vertical lines");
        }
        slope = (y2 - y1) / (x2 - x1);
        yIntercept = y1 - slope * x1;

        return new double[]{slope, yIntercept};
    }

    public static void main(String[] args){
		EquationOfLine obj = new EquationOfLine();
		
        Scanner input = new Scanner(System.in);

        // Taking inputs from the user
        System.out.print("Enter x1: ");
        double x1 = input.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = input.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = input.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = input.nextDouble();

        double distance = obj.calculateDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance between (%.2f, %.2f) and (%.2f, %.2f) = %.4f\n", x1,y1,x2,y2,distance);

        try{
            double[] equation = obj.findLineEquation(x1,y1,x2,y2);
            double slope = equation[0];
            double intercept = equation[1];

            System.out.printf("Equation of the line: y = %.2fx + %.2f\n",slope,intercept);
        }
		catch(ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println("Line is vertical, equation: x = " + x1);
        }
		input.close();
    }
}
