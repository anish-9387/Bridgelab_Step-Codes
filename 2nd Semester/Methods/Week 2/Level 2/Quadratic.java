import java.util.*;

// Class creation
public class Quadratic{
	// Method to find the roots of the quadratic equation
	public double[] calculateRoots(int a, int b, int c){
		double delta =  (int)Math.pow(b,2) - 4 * a * c;
		
		if(delta < 0){
			System.out.println("No roots exist");
			double[] roots = new double[0];
			return roots;
		}
		else if(delta == 0){
			double[] roots = new double[1];
			roots[0] = -b / 2 * a;
			return roots;
		}
		else{
			double[] roots = new double[2];
			roots[0] = (-b + Math.sqrt(delta)) / 2 * a;
			roots[1] = (-b - Math.sqrt(delta)) / 2 * a;
			return roots;
		}
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Quadratic quadratic = new Quadratic();
		
		// Taking the values of a,b and c
		System.out.print("Enter value of a: ");
		int a = input.nextInt();
		System.out.print("Enter value of b: ");
		int b = input.nextInt();
		System.out.print("Enter value of c: ");
		int c = input.nextInt();
		
		double[] roots = quadratic.calculateRoots(a,b,c);
		for(int i=0; i<roots.length; i++){
			System.out.print(roots[i] + " ");
		}
		input.close();
	}
}
