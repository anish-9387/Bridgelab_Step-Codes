import java.util.*;

// Class creation
class MeanHeight{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables and array for heights
		double mean, sum = 0;
		double[] heights = new double[11];
		
		// Taking the height from the user and calculating mean
		System.out.print("Enter the heights (in cm) of the players: ");
		for(int i=0; i<11; i++){
			heights[i] = input.nextDouble();
			sum += heights[i];
		}
		
		mean = sum / 11;
		
		System.out.println("The mean height of the football team (in cm): " + mean);
		input.close();
	}
}
