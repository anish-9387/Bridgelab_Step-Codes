import java.util.*;

// Class creation
public class ShortestTallestMean{	
	// Method to find the sum of all elements of an array
	public int sumOfArray(int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}
	
	// Method to find the mean height of the players
	public double findMeanHeight(int[] arr){
		int sum = sumOfArray(arr);
		return ((double)sum / arr.length);
	}
	
	// Method to find the shortest height among all the players
	public int findShortestHeight(int[] arr){
		int smallest = arr[0];
		for(int i=0; i<arr.length; i++){
			if(arr[i] < smallest){
				smallest = arr[i];
			}
		}
		return smallest;
	}
	
	// Method to find the tallest height among all the players
	public int findTallestHeight(int[] arr){
		int tallest = arr[0];
		for(int i=0; i<arr.length; i++){
			if(arr[i] > tallest){
				tallest = arr[i];
			}
		}
		return tallest;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Instantiation of object
		ShortestTallestMean obj = new ShortestTallestMean();
		
		int[] heights = new int[11];
		System.out.println("Enter heights of players: ");
		for(int i=0; i<heights.length; i++){
			System.out.print("Enter height of player " + (i+1) + ": ");
			heights[i] = input.nextInt();
			if(heights[i] < 150 || heights[i] > 250){
				System.out.println("Height is not between 150cm and 250cm!!!");
				System.out.print("Enter height of player " + (i+1) + ": ");
				heights[i] = input.nextInt();
			}
		}
		
		// Displaying all the results
		System.out.println("Sum of all elements present in array: " + obj.sumOfArray(heights));
		System.out.println("Mean height of the players in football team: " + obj.findMeanHeight(heights));
		System.out.println("Shortest height among all players in football team: " + obj.findShortestHeight(heights));
		System.out.println("Tallest height among all players in football team: " + obj.findTallestHeight(heights));
		
		input.close();
	}
}
