import java.util.*;

// Class creation
public class RandomNumbers{
	// Method to generate array of random numbers
	public int[] generate4DigitRandomArray(int size){
		int[] arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = (int)(Math.random() * 9000) + 1000;
		}
		return arr;
	}
	
	// Method to find average, min and max value from the random array
	public double[] findAverageMinMax(int[] numbers){
		double[] arr = new double[3];
	
		int min = numbers[0];
		int max = numbers[0];
		double sum = 0.0;

		for(int i=0; i<numbers.length; i++){
			sum += numbers[i];

			min = Math.min(min,numbers[i]);
			max = Math.max(max,numbers[i]);
		}
		arr[0] = min;
		arr[1] = max;
		arr[2] = sum / numbers.length;
		return arr;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		RandomNumbers rn = new RandomNumbers();
		
		// Calculating and printing the result
		int[] numbers = rn.generate4DigitRandomArray(5);
		
		System.out.print("Random-generated array: ");
		for(int i=0; i<numbers.length; i++){
			System.out.print(numbers[i] + " ");
		}
		
		double[] minMaxAvg = rn.findAverageMinMax(numbers);		
		System.out.println("\nMinimum value of random array: " + minMaxAvg[0]);
		System.out.println("Maximum value of random array: " + minMaxAvg[1]);
		System.out.println("Average value of random array: " + minMaxAvg[2]);
		input.close();
	}
}
