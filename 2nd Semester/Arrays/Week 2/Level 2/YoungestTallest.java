import java.util.*;

// Class creation
class YoungestTallest{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of arrays for the ages, heights and friends of the 3 people
		String[] people = {"Amar","Akbar","Anthony"};
		int[] age = new int[3];
		double[] height = new double[3];
		
		// Taking the inputs from the user
		System.out.print("Enter the ages of the three: ");
		for(int i=0; i<3; i++){
			age[i] = input.nextInt();
		}
		
		System.out.print("Enter the heights (in cm) of the three: ");
		for(int i=0; i<3; i++){
			height[i] = input.nextDouble();
		}
		
		// Finding and printing the results
		int minAgeIdx = 0;
		for(int i=0; i<3; i++){
			if(age[i] < age[minAgeIdx]){
				minAgeIdx = i;
			}
		}
		
		int maxHeightIdx = 0;
		for(int i=0; i<3; i++){
			if(height[i] > height[maxHeightIdx]){
				maxHeightIdx = i;
			}
		}
		
		System.out.println("The youngest friend is " + people[minAgeIdx] + " with age " + age[minAgeIdx] + " years");
        System.out.println("The tallest friend is " + people[maxHeightIdx] + " with height " + height[maxHeightIdx] + " cm");
		
		input.close();
	}
}
