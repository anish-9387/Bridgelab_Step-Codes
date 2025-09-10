import java.util.*;

// Class creation
public class YoungestAndTallest{
	
	public static String[] friends = {"Amar","Akbar","Anthony"};
	
	// Method to check youngest among three friends
	public void youngest(int[] age){
		int youngestIdx = 0;
		for(int i=0; i<age.length; i++){
			if(age[i] < age[youngestIdx]){
				youngestIdx = i;
			}
		}
		System.out.println("Youngest friend is: " + friends[youngestIdx] + " with age " + age[youngestIdx] + " yrs");
	}
	
	// Method to check tallest among three friends
	public void tallest(double[] height){
		int tallestIdx = 0;
		for(int i=0; i<height.length; i++){
			if(height[i] > height[tallestIdx]){
				tallestIdx = i;
			}
		}
		System.out.println("Tallest friend is: " + friends[tallestIdx] + " with height " + height[tallestIdx] + " cms");
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		YoungestAndTallest yt = new YoungestAndTallest();
		
		// Taking the age and height of 3 from the user
		int[] age = new int[3];
		double[] height = new double[3];
		for(int i=0; i<3; i++){
			System.out.print("Enter age of " + friends[i] + ": ");
			age[i] = input.nextInt();
			System.out.print("Enter height of " + friends[i] + " (in cms): ");
			height[i] = input.nextDouble();
		}
		
		yt.youngest(age);
		yt.tallest(height);
		input.close();
	}
}
