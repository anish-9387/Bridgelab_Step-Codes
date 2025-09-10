import java.util.*;

// Class creation
public class CollinearityChecker{
	// Method to check the collinearity of 3 points by slope formula
	public boolean checkCollinearityBySlope(double x1, double y1, double x2, double y2, double x3, double y3){
		double slopeAB = (y2 - y1) / (x2 - x1);
		double slopeBC = (y3 - y2) / (x3 - x2);
		double slopeAC = (y3 - y1) / (x3 - x1);
		
		return ((slopeAB == slopeBC) && (slopeBC == slopeAC));
	}
	
	// Method to check the collinearity of 3 points by triangle formula
	public boolean checkCollinearityByTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3){
		double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
		return area == 0.0;
	}
	
	public static void main(String[] args){
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
		System.out.print("Enter x3: ");
		double x3 = input.nextDouble();
		System.out.print("Enter y3: ");
		double y3 = input.nextDouble();
		
		CollinearityChecker obj = new CollinearityChecker();
		System.out.println("Are 3 points collinear? (Slope formula): " + obj.checkCollinearityBySlope(x1,y1,x2,y2,x3,y3));
		System.out.println("Are 3 points collinear? (Triangle area formula): " + obj.checkCollinearityByTriangleArea(x1,y1,x2,y2,x3,y3));
		input.close();
	}
}
